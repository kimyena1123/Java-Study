package org.delivery.api.common.error;


public interface ErrorCodeInterface {

    //에러코드는 다음 3가지를 반드시 제공해야 한다.
    Integer getHttpStatusCode(); //HTTP 상태 코드 (400, 500 등)
    Integer getErrorCode(); //개발자용 에러 코드 (1404 등)
    String getDescription(); //사용자 메시지

    //즉, 이 인터페이스는 모든 에러코드들이 가져야 할 공통 규칙이다.
}
