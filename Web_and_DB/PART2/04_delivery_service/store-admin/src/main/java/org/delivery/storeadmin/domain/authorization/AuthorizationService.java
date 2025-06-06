package org.delivery.storeadmin.domain.authorization;

import lombok.RequiredArgsConstructor;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.user.service.StoreUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/* AuthorizationService는 로그인 시 사용자의 정보를 확인하고 반환하는 역할.
    즉, Spring Security가 로그인 시 이메일(username)을 전달하면, 그걸 바탕으로 실제 유저 정보를 찾아서 UserDetails 객체로 반환하는 기능

    Spring Security는 로그인을 할 때
    1. 사용자가 로그인 요청 → 이메일 + 비밀번호 전달
    2. Spring Security 내부가 이메일(username)을 AuthorizationService에 넘김
    3. AuthorizationService가 DB에서 사용자 정보 조회
    4. 조회 결과를 UserDetails 객체로 만들어 반환
    5. Spring Security가 비밀번호 비교 → 일치하면 로그인 성공

        <<흐름>>
        [사용자 로그인 요청: 이메일 + 비밀번호]

        ↓ (Spring Security)

        AuthorizationService.loadUserByUsername("이메일") 호출

        ↓ (DB 조회)

        StoreUserService.getRegisterUser(email) → StoreUserEntity

        ↓ (UserDetails 객체로 변환)

        User.builder().username(...).password(...).roles(...).build()

        ↓ (Spring Security 내부 비밀번호 비교)

        로그인 성공 여부 결정

 */
public class AuthorizationService implements UserDetailsService { //UserDetailsService: Spring Security에서 로그인 시 유저 정보를 불러오기 위해 사용하는 인터페이스

    //StoreUserService: 유저 정보를 DB에서 가져오는 서비스 클래스 (DB 직접 접근은 하지 않음)
    private final StoreUserService storeUserService;
    private final StoreRepository storeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //Spring Security가 로그인 시 호출하는 메소드. 로그인 시 입력한 username(email)이 여기에 들어옴

        //사용자가 있는지 확인. 이메일(username)에 해당하는 유저를 DB에서 조회 (Optional<StoreUserEntity>)
        var storeUserEntity = storeUserService.getRegisterUser(username);
        var storeEntity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(storeUserEntity.get().getStoreId(), StoreStatus.REGISTERED);

        return storeUserEntity.map(it -> { //유저가 있으면 Spring Security에서 사용할 수 있는 User 객체로 만들어 반환

            var userSession = UserSession.builder()
                    .userId(it.getId())
                    .password(it.getPassword())
                    .email(it.getEmail())
                    .status(it.getStatus())
                    .role(it.getRole())
                    .registeredAt(it.getRegisteredAt())
                    .unregisteredAt(it.getUnregisteredAt())
                    .lastLoginAt(it.getLastLoginAt())

                    .storeId(storeEntity.get().getId())
                    .storeName(storeEntity.get().getName())
                    .build();

            return userSession;
        })
        .orElseThrow(() -> new UsernameNotFoundException(username)); //유저가 없으면 예외 던짐 → 로그인 실패 처리됨

    }
}
