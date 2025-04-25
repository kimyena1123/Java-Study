package org.delivery.api.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.common.error.ErrorCodeInterface;

/**
 * 사용 이유
 * 요청(Request)과 응답(Response)을 '항상 같은 모양'으로 만들기 위해서.
 * 요즘 백엔드에서는 무조건 "응답 포맷 통일"을 중요하게 생각한다.
 * 예를 들면, 클라이언트(앱, 웹) 입장에서 서버 응답이 매번 다르면 파싱하기 진짜 힘들다. 그래서 "우리는 항상 이런 형태로 응답하겠습니다." 라고 정하는 것이다.
 * {
 *         "result": {
 *         "resultCode": "OK",
 *                 "resultMessage": "성공"
 *     },
 *         "body": {
 *         "이 안에 실제 데이터가 들어감"
 *         }
 *     }
 * 즉, "Api<T>로 항상 똑같은 껍데기를 유지하고, 그 안에만 데이터(body)를 넣겠다"는 약속.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;


    public static <T> Api<T> OK(T data){
        var api = new Api<T>();
        api.result = Result.ok();
        api.body = data;

        return api;
    }

    public static Api<Object> ERROR(Result result){
        var api = new Api<Object>();
        api.result = result;

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, Throwable tx){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, tx);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, String description){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, description);

        return api;
    }
}
