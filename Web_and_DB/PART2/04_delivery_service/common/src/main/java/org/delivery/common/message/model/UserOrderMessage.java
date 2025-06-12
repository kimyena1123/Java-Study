package org.delivery.common.message.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderMessage {

    /* [구조]
    api 모듈
        └─ UserOrderProducer → 메시지 보냄
        └─ depends on: common

    store-admin 모듈
        └─ Consumer → 메시지 받음
        └─ depends on: common

    common 모듈
        └─ UserOrderMessage ← 양쪽에서 공유

        만약 이걸 common에 안 넣으면?
        한쪽에만 존재하므로 다른 모듈에서 접근 불가 + 코드 중복 + 유지보수 어려움 발생

     */

    private Long userOrderId;
}
