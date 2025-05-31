package org.delivery.api.domain.userorder.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.user.model.User;
import org.delivery.api.domain.userorder.converter.UserOrderConverter;
import org.delivery.api.domain.userorder.model.UserOrderRequest;
import org.delivery.api.domain.userorder.model.UserOrderResponse;
import org.delivery.api.domain.userorder.service.UserOrderService;
import org.delivery.api.domain.userordermenu.converter.UserOrderMenuConverter;
import org.delivery.api.domain.userordermenu.service.UserOrderMenuService;
import org.delivery.api.storemenu.service.StoreMenuService;

@Business
@RequiredArgsConstructor
public class UserOrderBusiness {

    private final UserOrderService userOrderService;
    private final StoreMenuService storeMenuService;
    private final UserOrderConverter userOrderConverter;
    private final UserOrderMenuConverter userOrderMenuConverter;
    private final UserOrderMenuService userOrderMenuService;


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


        //위 상세 메뉴들을 user_order_menu 테이블에 insert(save)한다.
        userOrderMenuEntityList.forEach(userOrderMenuService::order);

        //response
        return userOrderConverter.toResponse(newUserOrderEntity);
    }


}
