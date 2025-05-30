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

    //1. 사용자와 메뉴 id를 받아온다.
    //2. userOrder 생성
    //3. userOrderMenu 생성
    //4. 응답 생성
    public UserOrderResponse userOrder(User user, UserOrderRequest request){
        var storeMenuEntityList = request.getStoreMenuIdList()
                .stream()
                .map(it -> storeMenuService.getStoreMenuWithThrow(it))
                .toList();

        var userOrderEntity = userOrderConverter.toEntity(user, storeMenuEntityList);

        //주문
        var newUserOrderEntity = userOrderService.order(userOrderEntity);

        //매핑
        var userOrderMenuEntityList = storeMenuEntityList.stream()
                .map(it -> {
                    //menu + user order
                    var userOrdermenuEntity = userOrderMenuConverter.toEntity(newUserOrderEntity, it);

                    return userOrdermenuEntity;
                })
                .toList();

        //주문 내역 기록 남기기
        userOrderMenuEntityList.forEach(it -> {
            userOrderMenuService.order(it);
        });

        //response
        return userOrderConverter.toResponse(newUserOrderEntity);
    }
}
