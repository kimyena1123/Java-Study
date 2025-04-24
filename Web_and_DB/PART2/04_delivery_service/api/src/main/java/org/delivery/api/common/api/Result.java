package org.delivery.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.ErrorCodeInterface;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer resultCode;

    private String resultMessage;

    private String resultDescription;

    public static Result ok(){
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .resultDescription("성공") //상세 메시지
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface){ //매개변수: 어떠한 클래스, 어떠한 에러코드가 넘어올 지 모르지만 인터페이스에 있는 메소드를 통해 해당 값들에 접근할 거다.
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription("에러발생") //상세 메시지
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface, Throwable tx){
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription(tx.getLocalizedMessage()) //실제로 어떠한 메시지가 찍혔는지 client한테 내려준다. 비추. 위험할 수 있다.
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface, String description){ //특정 에러코드와 특정 메시지를 넘기면, 이걸 result에 담아서 response 내려갈 수 있도록 해준다
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription(description) //상세 메시지
                .build();
    }
}
