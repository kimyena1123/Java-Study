package org.delivery.api.domain.store.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //객체를 유연하고 편하게 만들기 위한 패턴. 보통 Response 객체처럼 "만들어서 전달"하는 경우에 적합하고, Request 객체는 사용자가 만든 데이터를 그대로 받기만 하면 되기 때문에 필요 없다.
public class StoreResponse {

    private Long id;

    private String name;

    private String address;

    private StoreCategory category;

    private StoreStatus status;

    private double star;

    private String thumbnailUrl;

    private BigDecimal minimumAmount;

    private BigDecimal minimumDeliveryAmount;

    private String phoneNumber;
}
