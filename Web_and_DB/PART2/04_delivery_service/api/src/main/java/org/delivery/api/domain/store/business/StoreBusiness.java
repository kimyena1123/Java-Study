package org.delivery.api.domain.store.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.api.domain.store.converter.StoreConverter;
import org.delivery.api.domain.store.service.StoreService;
import org.delivery.db.store.enums.StoreCategory;

import java.util.List;

@Business
@RequiredArgsConstructor
public class StoreBusiness {

    private final StoreService storeService;
    private final StoreConverter storeConverter;

    //store 등록: request 받음(DTO) -> entity화 -> 저장(save) -> entity를 response화 -> reponse를 return
    public StoreResponse register(StoreRegisterRequest storeRegisterRequest){
        //request -> entity -> 저장-> response
        var entity = storeConverter.toEnitty(storeRegisterRequest);
        var newEntity = storeService.register(entity);//저장
        var response = storeConverter.toResponse(newEntity);

        return response;
    }

    //등록된 store를 조회(category 기준으로 -> select * from store where category = ? and status = ?)
    public List<StoreResponse> searchCategory(StoreCategory storeCategory){
        //entity list를 가져와서 response list로 변환
        var storeList = storeService.searchByCategory(storeCategory);

        //데이터 변환
        /**
         * List<StoreEntity>는 우리가 원하는 List<StoreResponse>와 타입이 다르기 때문에, 각각의 Entity를 Response로 변환해야 한다.
         * 이때 for문 대신 stream을 쓰는 것
         * stream은 리스트 안의 요소들을 하나씩 순회하면서 변환/필터/정렬 등을 "함수형 스타일"로 처리하는 도구
         *
         * 이 방식은 안됨: var responseList = storeConverter.toResponse(storeList); // ❌ 안 됨
         * storeConverter.toResponse()는 보통 단일 Entity → Response만 처리하게 만들기 때문에, List 전체를 한꺼번에 변환할 수 없다.
         *
         * 아래 방식과 같이 for문으로도 할 수 있지만, 예전 스타일이다. stream을 사용하는게 코드가 더 간결하고 가독성이 좋다.
         * for (StoreEntity entity : storeList) {
         *     responses.add(storeConverter.toResponse(entity));
         * }
         */

        return storeList.stream()
                .map(storeConverter::toResponse)
                .toList();
    }
}
