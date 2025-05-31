package org.delivery.api.domain.userorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.userorder.enums.UserOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderResponse {
    //여기서는 메뉴나 특정 가게에 대한 정보가 있지 않다.
    //그런데 어플리케이션을 사용하다보면 특정 가게에서 언재, 어떤 메뉴를 주문했는지 등에 대한 정보가 필요할 수 있기 때문에,
    //지금 여기에 있는 response로는 해당 정보들을 담을 수 없다. 그래서 UserOrderDetailResponse에 담아준다.

    private Long id;

    private UserOrderStatus status;

    private BigDecimal amount;

    private LocalDateTime orderedAt;

    private LocalDateTime acceptedAt;

    private LocalDateTime cookingStartedAt;

    private LocalDateTime deliveryStartedAt;

    private LocalDateTime receivedAt;
}
