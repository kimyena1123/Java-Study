package org.delivery.api.storemenu.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.storemenu.converter.StoreMenuConverter;
import org.delivery.api.storemenu.model.StoreMenuRegisterRequest;
import org.delivery.api.storemenu.model.StoreMenuResponse;
import org.delivery.api.storemenu.service.StoreMenuService;

import java.util.List;

@Business
@RequiredArgsConstructor
public class StoreMenuBusiness {

    private final StoreMenuService storeMenuService;
    private final StoreMenuConverter storeMenuConverter;

    public StoreMenuResponse register(StoreMenuRegisterRequest request){
        // req -> entity -> save -> response
        var entity = storeMenuConverter.toEntity(request);
        var newEntity = storeMenuService.register(entity);
        var response = storeMenuConverter.toResponse(newEntity);

        return response;
    }

    public List<StoreMenuResponse> search(Long storeId){
        var list = storeMenuService.getStoreMenuByStoreId(storeId);

        return list.stream()
                .map(it -> {
                    return storeMenuConverter.toResponse(it);
                })
//                .map(storeMenuConverter::toResponse)
                .toList();
    }
}
