package org.delivery.storeadmin.domain.storemenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.storemenu.StoreMenuRepository;
import org.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreMenuService {

    private final StoreMenuRepository storeMenuRepository;

    //유효한 메뉴 찾기(예. 자바칩 음료가 있는지 확인, 딸기라뗴 있는지 확인 등 하나의 메뉴가 그 가게에 있는지 확인)
    //select * from store_menu where id = ? and status = ? order by id desc;
    public StoreMenuEntity getStoreMenuWithThrow(Long id){
        return storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED)
                .orElseThrow(() -> new RuntimeException("해당 메뉴를 찾을 수 없습니다(가게에 해당 메뉴가 없습니다"));
    }
}
