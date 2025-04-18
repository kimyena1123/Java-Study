package com.kimyena.jwt_token.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static String secretKey = "java11SpringBootJwtTokenIssueMethod";

    //token을 만들어주는 메서드
    public String craeteToken(
            Map<String, Object> claims, //클레임을 외부에서 받을거다. 데이터를 넘겨주는 클레임의 형태는 Map의 형태,
            LocalDateTime expireAt//만료일자 지정 <- 외부에서 받기
    ) {
        var key = Keys.hmacShaKeyFor(secretKey.getBytes()); //커스텀 키 사용
        var _expireAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant()); //LocalDateTime이 우리가 원하는 Date 형태로 바꿔준다.

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setExpiration(_expireAt) //이 시간이 지나면 만료된다
                .compact(); //String 타입을 리턴해준다.

    }

    //token을 검증해주는 메서드
    public void validatetionToken(String token) {

        var key = Keys.hmacShaKeyFor(secretKey.getBytes()); //커스텀 키 사용

        var parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        try{
            var result = parser.parseClaimsJws(token);

            result.getBody().entrySet().forEach(entry -> {
                log.info("key: {}, value: {}", entry.getKey(), entry.getValue());
            });
        }catch(Exception e){
            if(e instanceof SignatureException){
                throw new RuntimeException("JWT Token Not Valid Exception");
            }else if(e instanceof ExpiredJwtException){
                throw new RuntimeException("JWT Token Expired Exception");
            }else{
                throw new RuntimeException("JWT Token Validation Exception");
            }
        }

    }
}
