package org.delivery.api.common.exception;

import lombok.Getter;
import org.delivery.api.common.error.ErrorCodeInterface;

//이 클래스는 실제로 에러가 발생했을 때 던지는 예외 객체이다.
//즉, ApiException은 어떤 문제가 발생했는지에 대한 상세한 정보를 담은 포장지
/**
 * ApiException은 내가 직접 만든 예외 클래스.
 * 원래 RuntimeException 같은 걸 그냥 던져도 되지만, 내가 원하는 정보 (에러 코드, 설명 등)를 담아서 던질 수 있게 만든 것이다.
 *
 * @ExceptionHandler(ApiException.class) 같은 코드에서 “이건 내가 의도적으로 발생시킨 API 예외다” 라고 표시해주는 역할
 */
@Getter
public class ApiException extends RuntimeException implements ApiExceptionInterface{

    private final ErrorCodeInterface errorCodeInterface;
    private final String errorDescription;


    public ApiException(ErrorCodeInterface errorCodeInterface){
        super(errorCodeInterface.getDescription());

        this.errorCodeInterface = errorCodeInterface;
        this.errorDescription = errorCodeInterface.getDescription();
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, String errorDescription){
        super(errorCodeInterface.getDescription());

        this.errorCodeInterface = errorCodeInterface;
        this.errorDescription = errorDescription; // 내가 정의한 메시지를 지정하기
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, Throwable tx){
        super(tx);

        this.errorCodeInterface = errorCodeInterface;
        this.errorDescription = errorCodeInterface.getDescription();
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, Throwable tx, String errorDescription){
        super(tx);

        this.errorCodeInterface = errorCodeInterface;
        this.errorDescription = errorDescription;
    }
}
