package org.delivery.api.domain.token.ifs;

import org.delivery.api.domain.token.model.TokenDto;

import java.util.Map;

public interface TokenHelperInterface {

    TokenDto issueAccessToken(Map<String, Object> data);

    TokenDto issueRefreshToken(Map<String, Object> data);

    //validation 필요
    Map<String, Object> validationTokenWithThrow(String token);
}
