package org.delivery.storeadmin.domain.storemenu.converter;

import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.storeadmin.common.annotation.Converter;
import org.delivery.storeadmin.domain.storemenu.controller.model.StoreMenuResponse;

import java.util.List;

@Converter
public class StoreMenuConverter {

    public StoreMenuResponse toResponse(StoreMenuEntity storeMenuEntity){
        return StoreMenuResponse.builder()
                .id(storeMenuEntity.getStoreId())
                .name(storeMenuEntity.getName())
                .status(storeMenuEntity.getStatus())
                .amount(storeMenuEntity.getAmount())
                .thumbnailUrl(storeMenuEntity.getThumbnailUrl())
                .likeCount(storeMenuEntity.getLikeCount())
                .sequence(storeMenuEntity.getSequence())
                .build();
    }

    //메뉴는 N개가 담겨있을 수도 있기 때문에
    //리스트로도 받을 수 있다.
    public List<StoreMenuResponse> toResponse(List<StoreMenuEntity> list){
        return list.stream()
                .map(this::toResponse).toList(); //위에 정의한 toResponse 메소드 사용
    }
}
