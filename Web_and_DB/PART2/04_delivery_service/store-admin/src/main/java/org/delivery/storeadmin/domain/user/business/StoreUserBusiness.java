package org.delivery.storeadmin.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.delivery.storeadmin.common.annotation.Business;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.user.converter.StoreUserConverter;
import org.delivery.storeadmin.domain.user.service.StoreUserService;

@Business
@RequiredArgsConstructor
public class StoreUserBusiness {

    private final StoreUserConverter storeUserConverter;
    private final StoreUserService storeUserService;
    private final StoreRepository storeRepository; // TODO SERVICE로 변경하기

    public StoreUserResponse register(
            StoreUserRegisterRequest request
    ){
        var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTERED);

        //entity로 변환
        var entity = storeUserConverter.toEntity(request, storeEntity.get());

        //save
        var newEntity = storeUserService.register(entity);

        //response로 변환
        var response = storeUserConverter.toResponse(newEntity, storeEntity.get());

        return response;
    }
}
