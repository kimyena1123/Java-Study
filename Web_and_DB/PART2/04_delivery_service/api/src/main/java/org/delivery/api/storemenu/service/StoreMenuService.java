package org.delivery.api.storemenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.storemenu.StoreMenuRepository;
import org.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreMenuService {

    private final StoreMenuRepository menuRepository;
    private final StoreMenuRepository storeMenuRepository;

    //메뉴 등록(가게 메뉴 등록)
    public StoreMenuEntity register(
            StoreMenuEntity storeMenuEntity
    ){
        return Optional.ofNullable(storeMenuEntity)
                .map(it -> {
                    storeMenuEntity.setStatus(StoreMenuStatus.REGISTERED);

                    return storeMenuRepository.save(it);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    //해당 id를 넘겨주면 해당 가게에 있는 store를 찾아서 리턴해준다
    public StoreMenuEntity getStoreMenuWithThrow(Long id){
        var entity = storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED);

        return entity.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    //가게의 메뉴 다 가져오기
    public List<StoreMenuEntity> getStoreMenuByStoreId(Long StoreId){
        return storeMenuRepository.findAllByStoreIdAndStatusOrderBySequenceDesc(StoreId, StoreMenuStatus.REGISTERED);
    }
}
