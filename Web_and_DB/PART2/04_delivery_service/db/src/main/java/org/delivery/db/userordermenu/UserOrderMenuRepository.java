package org.delivery.db.userordermenu;

import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderMenuRepository extends JpaRepository<UserOrderMenuEntity, Long> {

    /*  조회하기(SELECT)
        사용자가 주문한 총내역에 대한 상세주문 보기
        ex)스터벅스 15,100원 주문했다면 -> 그 금액에 대한 상세 메뉴(아메리카노 1개, 카페라떼 2개)보기
        메뉴는 여러 개 있으므로 -> List 사용
        select * from user_order_menu where user_order_id = ? and status = ?
    */
    List<UserOrderMenuEntity> findAllByUserOrderIdAndStatus(Long UserOrderId, UserOrderMenuStatus status);
}
