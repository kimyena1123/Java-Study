package org.delivery.api.domain.token.helper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.TokenErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.ifs.TokenHelperInterface;
import org.delivery.api.domain.token.model.TokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenHelper implements TokenHelperInterface {

    //서명을 하기 위한 key 필요, 각 토큰에 대한 expiredAt 지정
    //application.yaml에 있는 3개의 값을 가져와야 한다.
    @Value("${token.secret.key}")
    private String secretKey;

    @Value("${token.access-token.plus-hour}")
    private Long accessTokenPlusHour;

    @Value("${token.refresh-token.plus-hour}")
    private Long refreshTokenPlusHour;



    @Override
    public TokenDto issueAccessToken(Map<String, Object> data) {

        //만료시간을 정해야 한다.
        var expiredLocalDateTime = LocalDateTime.now().plusHours(accessTokenPlusHour);

        var expiredAt = Date.from(expiredLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());

        //key 만들기
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        //token 만들기
        var jwtToken = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(data)
                .setExpiration(expiredAt) //언제 만료되는지
                .compact();

        return TokenDto.builder()
                .token(jwtToken)
                .expiresAt(expiredLocalDateTime)
                .build();

    }

    @Override
    public TokenDto issueRefreshToken(Map<String, Object> data) {
        //만료시간을 정해야 한다.
        var expiredLocalDateTime = LocalDateTime.now().plusHours(refreshTokenPlusHour);

        var expiredAt = Date.from(expiredLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());

        //key 만들기
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        //token 만들기
        var jwtToken = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(data)
                .setExpiration(expiredAt) //언제 만료되는지
                .compact();

        return TokenDto.builder()
                .token(jwtToken)
                .expiresAt(expiredLocalDateTime)
                .build();
    }

    @Override
    public Map<String, Object> validationTokenWithThrow(String token) {

        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        var parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        //파싱할 때 에러가 발생 -> try~catch{} 사용
        try{

            var result = parser.parseClaimsJws(token);

            return new HashMap<String, Object>(result.getBody());

        }catch(Exception e){
            //예외는 총 3가지가 발생한다

            if(e instanceof SignatureException){ // 토큰이 유효하지 않을 때 발생하는 에러
                throw new ApiException(TokenErrorCode.INVALID_TOKEN, e);
            }else if(e instanceof ExpiredJwtException){ // 만료된 토큰일 때 발생하는 에러
                throw new ApiException(TokenErrorCode.EXPIRED_TOKEN, e);
            }else{ // 알 수 없는 그 외의 에러
                throw new ApiException(TokenErrorCode.TOKEN_EXCEPTION, e);
            }
        }
    }
}
