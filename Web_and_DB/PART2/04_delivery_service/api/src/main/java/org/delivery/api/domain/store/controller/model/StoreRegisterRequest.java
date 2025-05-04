package org.delivery.api.domain.store.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.store.enums.StoreCategory;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterRequest { //가게 사장이 가게를 등록하려고 한다. 등록하기 위해서 필요한 정보

    //아래 정보를 받아서 store 등록.
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull //enum 타입이기 떄문에 null 값이 들어오면 안된다는 의미로 @NotNull 사용
    private StoreCategory category;

    @NotBlank
    private String thumbnailUrl;

    @NotNull
    private BigDecimal minimumAmount;

    @NotNull
    private BigDecimal minimumDeliveryAmount;

    @NotBlank
    private String phoneNumber;
}
