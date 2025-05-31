package org.delivery.api.domain.userorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.api.storemenu.model.StoreMenuResponse;
import org.delivery.db.storemenu.StoreMenuEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*  왜 Response들을 필드로 사용하는가?
    1. 복합 응답 구조를 다루기 위해서.
        ex) 사용자가 어떤 가게에서 어떤 메뉴를 주문했다 => 필요한 정보: 주문 자체(UserOrderResponse), 가게 정보(StoreResopnse), 메뉴 정보(List<StoreMenuResponse>)
            이 여러가지 응답을 하나로 감싸는 응답이 필요하다! -> UserOrderDetailResponse
    2. 클라이언트에게 필요한 정보만 정제해서 전달하기 위해
        Entity 객체 그대로 반환하면, DB구조와 로직이 노출됨 -> 보안/유지보수에 안좋음
        그래서 Response객체를 따로 만들어, 원하는 정보만 보내기 위해 사용
    => 즉, 복합적인 정보를 한번에 전달하기 위해 여러 Response 객체들을 필드로 가지도록 했다.
 */
public class UserOrderDetailResponse { // 조금 더 상세한 정보들을 담는다.
    // 다른 Response들은 테이블에 대한 컬럼들에 대한 정보들만 담았다면,
    // 이 Response는 하나의 테이블에 대한 정보만 필요한 게 아닌 "user_order", "store", "store_menu" 테이블에 대한 정보들이 다 필요하다
    // 각 테이블에 대한 필드를 하나하나 다 작성할 수 있지만, 권장X

    private UserOrderResponse userOrderResponse; // 사용자가 주문한 주문건에 대한 response
    private StoreResponse storeResponse; // 그 가게에 대한 store에 대한 정보 response
    private List<StoreMenuResponse> storeMenuResponseList;//어떠한 메뉴를 주문했는지 N건에 대한 내역. 여러 건의 주문 내역을 가지니까 List.

}
