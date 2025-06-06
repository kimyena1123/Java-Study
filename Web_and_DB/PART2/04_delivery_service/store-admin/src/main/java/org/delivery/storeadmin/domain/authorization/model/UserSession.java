package org.delivery.storeadmin.domain.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*  UserDetails는 interface로 되어 있다. -> 이 인터페이스를 상속받아서 재정의
    UserSession 클래스는 Spring Security에서 로그인된 사용자 정보를 표현하기 위해 사용하는 클래스
    UserSerssion은 UserDetails 인터페이스를 구현한 Spring Security 사용자 인증 정보 객체

    [언제 사용되는가?]
    사용자가 로그인하면 UserDetailsService가 사용자 정보를 DB에서 조회하고, 이때 반환하는 객체가 바로 이 UserSerssion이다. Spring Security는 이 객체를 기반으로 인증, 권한 검사, 계정 상태 체크 등을 한다.
 */
public class UserSession implements UserDetails {

    //user와 관련된 정보 담기
    private Long userId;
    private String email;
    private String password;
    private StoreUserStatus status;
    private StoreUserRole role;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime lastLoginAt;

    //store와 관련된 정보 담기
    private Long storeId;
    private String storeName;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //사용자의 권한 정보를 반환
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getPassword() { //사용자의 비밀번호 반환 (Spring이 비밀번호 일치 여부 검사할 때 사용)
        return this.password;
    }

    @Override
    public String getUsername() { // 사용자의 로그인 ID 반환. 여기선 email
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() { // 계정이 만료되었는지 여부. false면 로그인 불가.
        return this.status == StoreUserStatus.REGISTERED; //status가 REGISTERED라면 만료가 안된 상태를 의미(여기서는 상태가 REGISTERED인 경우만 true)
    }

    @Override
    public boolean isAccountNonLocked() { // 계정이 잠겼는지 여부. false면 로그인 불가.
        return this.status == StoreUserStatus.REGISTERED; //status가 REGISTERED라면 잠긴 상태가 아님
    }

    @Override
    public boolean isCredentialsNonExpired() { // 자격 증명(비밀번호 등)이 만료되었는지 여부
        return this.status == StoreUserStatus.REGISTERED;
    }

    @Override
    public boolean isEnabled() { //계정이 활성화되어 있는지 여부. 여기선 항상 true로 설정
        return true;
    }
}
