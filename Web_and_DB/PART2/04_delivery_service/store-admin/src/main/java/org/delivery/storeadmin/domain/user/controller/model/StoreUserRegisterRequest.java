package org.delivery.storeadmin.domain.user.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreUserRegisterRequest {

    //가입할 때 무엇이 필요한가?
    @NotBlank
    private String storeName; //어떠한 가게의

    @NotBlank
    private String email; //email은 무엇이고

    @NotBlank
    private String password;

    @NotBlank
    private StoreUserRole role; // 이러한 역할로 신청한다
}
