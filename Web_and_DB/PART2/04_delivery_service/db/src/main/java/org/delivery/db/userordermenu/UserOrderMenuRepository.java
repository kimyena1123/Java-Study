package org.delivery.db.userordermenu;

import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderMenuRepository extends JpaRepository<UserOrderMenuEntity, Long> {

    // user order menu를 가져오는 건 특정 id로 가져오지 않고(즉, user_order_menu 테이블의 id로 가져오는 게 아니라), 그 상위에 있는
    //user_order 테이블(주문 내역)에서 가져온다. userordermenuId를 가져오는게 아니라 userorderId를 가져온다.
    //select * from user_order_menu where user_order_id = ? and status = ?
    List<UserOrderMenuEntity> findAllByUserOrderIdAndStatus(Long UserOrderId, UserOrderMenuStatus status);
}
