package org.delivery.api.config.objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * Jackson ObjectMapper 설정
 * - JSON 직렬화/역직렬화 시 필요한 포맷, 날짜 처리, 네이밍 전략 등을 지정
 * - objectMapper란? JSON <-> Java 객체 간 변환을 담당하는 Jackson 라이브러리의 핵심 클래스임.
 * - 왜 사용? pring Boot는 기본적으로 ObjectMapper를 자동으로 만들어서 사용한다. 그런데 기본 설정은 모든 프로젝트에 최적화되어 있지 않음. 그래서 커스터마이징 함
 */
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();

        // Optional 같은 Java 8+(jdk 8버전 이후 클래스) 타입 직렬화 지원
        objectMapper.registerModule(new Jdk8Module());

        // LocalDate, LocalDateTime 등 날짜 타입 직렬화 지원
        objectMapper.registerModule(new JavaTimeModule()); // << local date

        // JSON에 정의되지 않은 필드는 무시
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 모르는 json field 대해서는 무시한다

        // 비어 있는 객체 직렬화 오류 방지
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 날짜를 timestamp(숫자) 대신 ISO-8601 문자열 포맷으로 직렬화
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Java의 camelCase를 JSON의 snake_case로 변환
        // 예: userName → "user_name"
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }
}
