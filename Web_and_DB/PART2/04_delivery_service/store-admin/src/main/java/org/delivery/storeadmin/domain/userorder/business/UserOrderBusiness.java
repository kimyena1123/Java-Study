package org.delivery.storeadmin.domain.userorder.business;

import lombok.RequiredArgsConstructor;
import org.delivery.common.message.model.UserOrderMessage;
import org.delivery.storeadmin.common.annotation.Business;
import org.delivery.storeadmin.domain.sse.connection.SseConnectionPool;
import org.delivery.storeadmin.domain.storemenu.converter.StoreMenuConverter;
import org.delivery.storeadmin.domain.storemenu.service.StoreMenuService;
import org.delivery.storeadmin.domain.userorder.controller.model.UserOrderDetailResponse;
import org.delivery.storeadmin.domain.userorder.converter.UserOrderConverter;
import org.delivery.storeadmin.domain.userorder.service.UserOrderService;
import org.delivery.storeadmin.domain.userordermenu.service.UserOrderMenuService;

import java.util.List;

@Business
@RequiredArgsConstructor
public class UserOrderBusiness {

    private final UserOrderService userOrderService;
    private final SseConnectionPool sseConnectionPool;

    private final UserOrderMenuService userOrderMenuService;
    private final UserOrderConverter userOrderConverter;

    private final StoreMenuService storeMenuService;
    private final StoreMenuConverter storeMenuConverter;

    /** [가게 사장한테 주문 알림 보내기]
     * 1. 손님이 주문해서 -> 주문이 들어온다
     * 2. 주문 내역 찾는다
     * 3. 해당 주문에 대응하는 가게(store) 찾기
     * 4. 해당 가게의 세션 찾아서
     * 5. push 해준다
     */
    public void pushUserOrder(UserOrderMessage userOrderMessage){
        //1. 주문 내역 찾기
        var userOrderEntity = userOrderService.getUserOrder(userOrderMessage.getUserOrderId())
                .orElseThrow(() -> new RuntimeException("사용자 주문내역 없음"));

        //2. 사용자 주문(user_order) entity화

        //3. 사용자 주문(user_order)을 가져왔으니 상세메뉴(user_order_menu)를 뽑아낼 수 있다. 메뉴는 여러 개니까 List
        //  select * from user_order_menu where user_order_id = ? and status = ?
        var userOrderMenuList = userOrderMenuService.getUserOrderMenuList(userOrderEntity.getId());

        //4. 위에서 가져온 이 상세메뉴를 store_menu로 바꿔줄 수 있다.(사용자 상세주문 메뉴 하나하나가 그 가게에 있는지)
        //그러면 StoreMenuEntity로 된다
        var storeMenuResponseList = userOrderMenuList.stream()
                .map(userOrderMenuEntity -> {
                    //유효한 메뉴 찾기(예. 자바칩 음료가 있는지 확인, 딸기라뗴 있는지 확인 등 하나의 메뉴가 그 가게에 있는지 확인)
                    //select * from store_menu where id = ? and status = ? order by id desc;
                    return storeMenuService.getStoreMenuWithThrow(userOrderMenuEntity.getStoreMenuId());
                })
                .map(storeMenuEntity -> {
                    return storeMenuConverter.toResponse(storeMenuEntity);
                })
                .toList();

        //5. response에 담아서
        var usrOrderResponse = userOrderConverter.toResponse(userOrderEntity);

        var push = UserOrderDetailResponse.builder()
                .userOrderResponse(usrOrderResponse)
                .storeMenuResponses(storeMenuResponseList)
                .build();


        //사용자 주문 내역 찾았으니 올바른 데이터 형태 만들어주기
        //storeId를 가지고 session을 찾을 수 있다
        var userConnection = sseConnectionPool.getSession(userOrderEntity.getStoreId().toString());


        //6. 사용자에게 push
        userConnection.sendMessage(push);
    }
}
