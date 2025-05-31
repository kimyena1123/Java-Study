package org.delivery.api.domain.userordermenu.converter;

import org.delivery.api.common.annotation.Converter;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userordermenu.UserOrderMenuEntity;

@Converter
public class UserOrderMenuConverter {

    public UserOrderMenuEntity toEntity(
            UserOrderEntity userOrderEntity,
            StoreMenuEntity storeMenuEntity
    ){
        return UserOrderMenuEntity.builder()
                .userOrderId(userOrderEntity.getId())//user_order_menu 테이블의 자체 컬럼이 아닌, user_order에서 가져온 것이기 때문
                .storeMenuId(storeMenuEntity.getId())//user_order_menu 테이블의 자체 컬럼이 아닌, store_menu에서 가져온 것이기 때문
                .build();
    }
}
