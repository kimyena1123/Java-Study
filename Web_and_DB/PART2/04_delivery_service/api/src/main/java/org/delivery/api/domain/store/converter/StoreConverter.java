package org.delivery.api.domain.store.converter;

import org.delivery.api.common.annotation.Converter;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.db.store.StoreEntity;

import java.util.Optional;

@Converter
//사용자에게 받은 요청(Request DTO)은 toEntity()로 변환해서 DB에 저장하고,
// 저장된 결과(Entity)는 toResponse()로 변환해서 사용자에게 응답(Response DTO)으로 준다.
public class StoreConverter {

    //사용자 요청(request)를 eneity로( DTO => Entity )
    public StoreEntity toEnitty(StoreRegisterRequest request){

        return Optional.ofNullable(request) //null값이 들어올 수도 있기에
                .map(it -> {
                    return StoreEntity.builder() // Entity화 할거야!
                            .name(request.getName())
                            .address(request.getAddress())
                            .category(request.getCategory())
                            .minimumAmount(request.getMinimumAmount())
                            .minimumDeliveryAmount(request.getMinimumDeliveryAmount())
                            .thumbnailUrl(request.getThumbnailUrl())
                            .phoneNumber(request.getPhoneNumber())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }


    //저장된 결과를 사용자에게 보여줄 응 형태로 변환( Entity => DTO )
    public StoreResponse toResponse(StoreEntity entity){

        return Optional.ofNullable(entity) //null값이 들어올 수도 있기에
                .map(it -> {
                    return StoreResponse.builder() // Response화 할거야!
                            .id(entity.getId())
                            .name(entity.getName())
                            .status(entity.getStatus())
                            .category(entity.getCategory())
                            .address(entity.getAddress())
                            .minimumAmount(entity.getMinimumAmount())
                            .minimumDeliveryAmount(entity.getMinimumDeliveryAmount())
                            .thumbnailUrl(entity.getThumbnailUrl())
                            .phoneNumber(entity.getPhoneNumber())
                            .star(entity.getStar())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }


}
