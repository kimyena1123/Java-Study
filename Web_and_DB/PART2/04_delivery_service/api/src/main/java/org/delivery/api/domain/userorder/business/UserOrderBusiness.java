package org.delivery.api.domain.userorder.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.store.converter.StoreConverter;
import org.delivery.api.domain.store.service.StoreService;
import org.delivery.api.domain.user.model.User;
import org.delivery.api.domain.userorder.converter.UserOrderConverter;
import org.delivery.api.domain.userorder.model.UserOrderDetailResponse;
import org.delivery.api.domain.userorder.model.UserOrderRequest;
import org.delivery.api.domain.userorder.model.UserOrderResponse;
import org.delivery.api.domain.userorder.producer.UserOrderProducer;
import org.delivery.api.domain.userorder.service.UserOrderService;
import org.delivery.api.domain.userordermenu.converter.UserOrderMenuConverter;
import org.delivery.api.domain.userordermenu.service.UserOrderMenuService;
import org.delivery.api.storemenu.converter.StoreMenuConverter;
import org.delivery.api.storemenu.service.StoreMenuService;

import java.util.List;

@Business
@RequiredArgsConstructor
public class UserOrderBusiness {

    private final UserOrderService userOrderService;
    private final StoreMenuService storeMenuService;
    private final UserOrderConverter userOrderConverter;
    private final UserOrderMenuConverter userOrderMenuConverter;
    private final UserOrderMenuService userOrderMenuService;
    private final StoreService storeService;
    private final StoreMenuConverter storeMenuConverter;
    private final StoreConverter storeConverter;
    private final UserOrderProducer userOrderProducer; //가맹점 서버에 주문 알림 보내기

    /*  사용자 주문(INSERT): 사용자 정보와 request 정보를 받아 user_order과 user_order_menu 테이블에 저장한다
        controller에서 로그인된 사용자 정보(user)와 가게 메뉴 id들(store_menu의 id)이 담겨있는 request(request에는 List가 있다)를 보냄
        ex) 사용자가 스타벅스 카페의 store_menu id가 5,6번인 아메리카노와 카페라떼를 주문했다고 하자. request에는 List가 담겨있고 List에는 5,6이 담겨있는 것임
            즉, request에는 사용자가 먹고 싶은 메뉴의 id인 5,6번이 담겨있다.
            해당 메뉴들의 가격을 더해 총 금액을 구하고 user_order 테이블에 추가한다 -> user_order_menu 테이블에도 추가한다.

        정리) 사용자(user)와 메뉴 id들(request)을 받아온다 => userOrder 생성(INSERT) => userOrderMenu 생성(INSERT) => response 생성

        1. request -> entity로 바꿈
        2. entity를 save함 : Service에서 한다
        3. save된 entity -> response로 바꿈
        4. response를 return한다
     */
    public UserOrderResponse userOrder(User user, UserOrderRequest userOrderRequest) {

        //request에 저장되어 있는 store_menu id를 stream으로 하나씩 돌면서 해당 id에 해당하는 store_menu 정보 가져오기
        //store_menu의 id가 5라면, 5라는 숫자를 넘겨 해당 id(5)의 store_menu 테이블에 저장되어 있는 행 정보 가져오기.(getStoreMenuWithThrow 메소드 사용)
        var storeMenuEntityList = userOrderRequest.getStoreMenuIdList() //사용자가 메뉴 4,5를 주문했다면, 4,5에 해당하는 전체 행 2개가 저장된다
                .stream()
                .map(storeMenuService::getStoreMenuWithThrow)
                .toList();


        //request를 entity로 바꾸기
        //위 4,5번 메뉴의 가격을 합친 후, 하나의 entity로 나온다. 즉, 위의 상세메뉴들에 대한 하나의 총 주문 내역이(user_order) 나오는 것임
        var userOrderEntity = userOrderConverter.toEntity(user, storeMenuEntityList);

        //entity를 save하기: Service에서(주문하기)
        //위 userOrderEntity를 user_order 테이블에 insert(save)한다
        var newUserOrderEntity = userOrderService.order(userOrderEntity);


        //========== 여기서부터는 상세 메뉴(user_order_menu 테이블과 관련된 코드) ==========
        //매핑
        //위의 entity는 각각 4,5번에 대한 하나의 주문 내역을 entity 했다면, 이제는 각각 주문에 대한 상세 주문 메뉴(4번과 5번)을 entity화한다(user_order_menu에도 저장할 것이기 떄문)
        //(userOrderId=3, storeMenuId=4, status=null), (userOrderId=3, storeMenuId=5, status=null) 이렇게 2개가 List에 담긴다
        var userOrderMenuEntityList = storeMenuEntityList.stream() //storeMenuEntityList에는 숫자(사용자가 주문한 메뉴들의 id)가 담겨있다
                .map(it -> {
                    //menu + user order
                    return userOrderMenuConverter.toEntity(newUserOrderEntity, it);
                }).toList();


        //주문내역 기록 남기기 : 위 상세 메뉴들을 user_order_menu 테이블에 insert(save)한다.
        userOrderMenuEntityList.forEach(userOrderMenuService::order);

        //비동기로 가맹점에 주문 알리기(rabbitmq 사용)
        userOrderProducer.sendOrder(newUserOrderEntity); //비동기로 사용자의 주문이 날라가게 된다

        //response
        return userOrderConverter.toResponse(newUserOrderEntity);
    }


    /* 현재 진행중인 주문 내역 보기(SELECT)
     * 현재 진행중인 주문이 여러 개 있을 수 있다! => List
     * SELECT * FROM user_order WHERE status IN (ORDER, ACCEPT, COOKING, DELIVERY, RECEIVE) AND user_id = ?
     * 로직 설명: user와 user_order은 1:N관계, user_order과 user_order_menu도 1:N관계
     *          user_order에서 여러개의 user_order_menu 정보 가져옴. 그리고 그 해당 user_order_menu에서 store_menu_id를 이용해 store_menu 정보를 가져옴
     *          가져온 store_menu를 이용해 store 정보를 가져옴
     * 즉, user -> user_order -> user_order_menu -> store_menu -> store 순으로 여러 개의 테이블 정보를 다 가져오는 것이다.
     */
    public List<UserOrderDetailResponse> current(User user) {
        //진행중인 주문 내역 => 여러 개일 수도 있다(List)
        //!!! 상태가 ORDER, COOKING, DELIVERY, ACCEPT인 user_order 정보 가져오기 !!!
        var userOrderEntityList = userOrderService.current(user.getId());

        //해당 여러 개가 담긴 user_order을 stream으로 반복문 돌기
        var userOrderDetailResponseList = userOrderEntityList.stream().map(user_order -> {

            //!!! 하나의 user_order에 대한 상세 주문 메뉴들 가져오기 !!!
            //하나의 가게 주문에 대한 여러 개의 상세메뉴들이 담겨있다(예. 스타벅스에서 15100원 시킴 -> 아아 1잔, 카페라떼 2잔) => 3개의 행에 대한 정보가 있다.
            var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(user_order.getId());

            //!!! store_menu 테이블의 정보를 가져오기 !!!
            var storeMenuEntityList = userOrderMenuEntityList.stream().map(user_order_menu -> {
                var storeMenuEntity = storeMenuService.getStoreMenuWithThrow(user_order_menu.getStoreMenuId()); //store_menu 테이블의 한 행 정보를 가져옴
                return storeMenuEntity;
            }).toList();

            //!!! 사용자가 주문한 가게 정보(store) 가져오기 !!! TODO 리팩토링 필요
            var storeEntity = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

            return UserOrderDetailResponse.builder()
                    .userOrderResponse(userOrderConverter.toResponse(user_order))
                    .storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
                    .storeResponse(storeConverter.toResponse(storeEntity))
                    .build();
        }).toList();

        return userOrderDetailResponseList;
    }

    /* 과거 주문한 내역 보기(SELECT)
     * 과거 주문이 여러 개 있을 수 있다! => List
     */
    public List<UserOrderDetailResponse> history(User user) {
        //!!! status가 RECEIVE인 user_order의 모든 내역 가져오기 !!!
        var userOrderEntityList = userOrderService.history(user.getId());

        var userOrderDetailResponseList = userOrderEntityList.stream().map(user_order -> {

            // !!! 하나의 user_order 정보에 대한 상세 메뉴 가져오기 !!!
            var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(user_order.getId());

            // !!! store_menu 테이블에 대한 정보 가져오기 !!!
            var storeMenuEntityList = userOrderMenuEntityList.stream().map(user_order_menu -> {
                return storeMenuService.getStoreMenuWithThrow(user_order_menu.getStoreMenuId());
            }).toList();

            // !!! 해당 store_menu에 대한 store 가게 대한 정보 가져오기 !!!  TODO 리팩토링 필요
            var storeEntity = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

            return UserOrderDetailResponse.builder()
                    .userOrderResponse(userOrderConverter.toResponse(user_order))
                    .storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
                    .storeResponse(storeConverter.toResponse(storeEntity))
                    .build();
        }).toList();

    return userOrderDetailResponseList;

    }

    /* 주문 1건에 대한 내역 보기(SELECT)
    SELECT * FROM user_order WHERE id = ? AND status = ? AND user_id = ?
    */
    public UserOrderDetailResponse read(User user, Long orderId) {
        var userOrderEntity = userOrderService.getUserOrderWithOutStatusWithThrow(orderId, user.getId());

        // !!! 하나의 user_order 정보에 대한 상세 메뉴 가져오기 !!!
        var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(userOrderEntity.getId());

        var storeMenuEntityList = userOrderMenuEntityList.stream().map(user_order_menu -> {
            var storeMenuEntity = storeMenuService.getStoreMenuWithThrow(user_order_menu.getStoreMenuId());

            return storeMenuEntity;
        }).toList();

        //사용자가 주문한 스토어 TODO 리팩토링 필요
        var storeEntity = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

        return UserOrderDetailResponse.builder()
                .userOrderResponse(userOrderConverter.toResponse(userOrderEntity))
                .storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
                .storeResponse(storeConverter.toResponse(storeEntity))
                .build();
    }
}
