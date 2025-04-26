package org.delivery.api.domain.token.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.ifs.TokenHelperInterface;
import org.delivery.api.domain.token.model.TokenDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * token에 대한 도메인 로직
 */
@Service
@RequiredArgsConstructor
public class TokenService {

    //TokenService 같은 경우는 외부 라이브러리의 도움을 받기 때문에, tokenHelper라는 인터페이스를 뒀다.
    //그리고 이 인터페이스를 상속받은 helper를 api/domain/token/helper/JwtTokenHelper에 뒀다.
    private final TokenHelperInterface tokenHelperInterface;


    public TokenDto issueAccessToken(Long userId){

        var data = new HashMap<String, Object>();
        data.put("userId", userId);

        return tokenHelperInterface.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(Long userId){
        var data = new HashMap<String, Object>();
        data.put("userId", userId);

        return tokenHelperInterface.issueRefreshToken(data);
    }

    public Long validationToken(String token){
        var map = tokenHelperInterface.validationTokenWithThrow(token);
        var userId = map.get("userId");

        Objects.requireNonNull(userId, () -> {throw new ApiException(ErrorCode.NULL_POINT);});

        return Long.parseLong(userId.toString());
    }
}
