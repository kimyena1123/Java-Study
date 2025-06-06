package org.delivery.db.store;

import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    //특정 유효한 스토어(id + status)
    //select * from store where id = ? and status = ? order by id desc limit 1;
    Optional<StoreEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, StoreStatus status);

    //유효한 스토어 리스트
    //select * from store where status = ? order by id desc;
    List<StoreEntity> findAllByStatusOrderByIdDesc(StoreStatus status);

    //유효한 특정 카테고리의 스토어 리스트(좋아요 수가 많은 순대로 정렬해서)
    //select * from store where status = ? and category = ? order by start desc;
    List<StoreEntity> findAllByStatusAndCategoryOrderByStarDesc(StoreStatus status, StoreCategory category);

    //SELECT * FROM store WHERE name = ? AND status = ? ORDER BY id DESC LIMIT 1
    Optional<StoreEntity> findFirstByNameAndStatusOrderByIdDesc(String name, StoreStatus status);
}
