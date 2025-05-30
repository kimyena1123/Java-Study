package org.delivery.api.domain.userorder.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderRequest {

    //사용자 주문을 위한 request
    //주문 => 특정 사용자가 => 특정 메뉴를 주문
    //특정 사용자란 => 로그인된 세션에 들어있는 사용자를 의미
    //주문 => 특정 메뉴 id만 올려주면 된다.

    //사용자는 로그인된 사용자를 쓸 것이기 때문에, 별도로 받을 필요가 없고 그래서 어떤 메뉴를 주문하겠다만 있으면 된다.
    @NotNull
    private List<Long> storeMenuIdList;
}
