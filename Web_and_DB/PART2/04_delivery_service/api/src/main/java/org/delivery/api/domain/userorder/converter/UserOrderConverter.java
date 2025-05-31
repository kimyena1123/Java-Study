package org.delivery.api.domain.userorder.converter;

import org.delivery.api.common.annotation.Converter;
import org.delivery.api.domain.user.model.User;
import org.delivery.api.domain.userorder.model.UserOrderResponse;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;

import java.math.BigDecimal;
import java.util.List;

@Converter
public class UserOrderConverter {

    // controller에서 로그인된 사용자 정보와 사용자가 주문한 상세 주문 메뉴들(store_menu 테이블의 id들)을 받아 entity화
    // 여러 메뉴가 List에 담겨있음(4,5 이와 같은 숫자로 들어가 있다)
    public UserOrderEntity toEntity(User user, List<StoreMenuEntity> storeMenuEntityList){

        //해당 List를 stream으로 돌면서 해당 id에 해당하는 amount를 가져온다. 가져온 amount들을 더해서 총합을 구한다.
        var totalAmount = storeMenuEntityList.stream()
                .map(StoreMenuEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //위 총주문금액을 구하고 eneity화
        return UserOrderEntity.builder()
                .userId(user.getId())
                .amount(totalAmount)
                .build();
    }

    public UserOrderResponse toResponse(UserOrderEntity userOrderEntity) {
        return UserOrderResponse.builder()
                .id(userOrderEntity.getId())
                .status(userOrderEntity.getStatus())
                .amount(userOrderEntity.getAmount())
                .orderedAt(userOrderEntity.getOrderedAt())
                .acceptedAt(userOrderEntity.getAcceptedAt())
                .cookingStartedAt(userOrderEntity.getCookingStartedAt())
                .deliveryStartedAt(userOrderEntity.getDeliveryStartedAt())
                .receivedAt(userOrderEntity.getReceivedAt())
                .build();
    }
}
