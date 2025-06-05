package org.delivery.storeadmin.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreUserResponse {

    private UserResponse user;
    private StoreResponse store;

    /* 복합구조로 작성 : 가맹점 점주(StoreUser)는 특정 가맹점(Store)에 소속되어 있다
        즉, 하나의 점주(user) 정보만으로는 부족하고, 그 점주가 어느 가맹점(store) 에 속해있는지 둘 다 함께 보여줘야 한다.
        예를 들어, 점주가 로그인하면 서버는 프론트에 아래와 같은 정보를 내려준다.
        이와 같이 ==> user 정보와 store 정보를 같이 보내주는 것이 프론트엔드 입장에서 훨씬 편하고 직관적이다.
        {
          "user": {
            "id": 10,
            "email": "boss@store.com",
            "status": "REGISTERED",
            "role": "OWNER",
            "registeredAt": "2024-05-01T10:00:00"
          },
          "store": {
            "id": 3,
            "name": "스타벅스 강남점"
          }
        }

        이 방식은 여러 도메인의 정보를 하나로 묶어서 내려줘야 할 때, 복잡한 프론트 요청에 대응하기 위해 응답 형태를 커스터마이징할 때 사용한다
     */

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserResponse{
        //storeUserEntity내용 넣기
        private Long id;
        private String email;
        private StoreUserStatus status;
        private StoreUserRole role;
        private LocalDateTime registeredAt;
        private LocalDateTime unregisteredAt;
        private LocalDateTime lastLoginAt;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class StoreResponse{
        //store 유저는 어떠한 store에 해당하기 때문에 가맹점 id랑 이름만.
        private Long id;
        private String name;
    }
}
