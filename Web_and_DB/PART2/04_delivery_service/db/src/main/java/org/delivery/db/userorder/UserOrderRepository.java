package org.delivery.db.userorder;

import org.delivery.db.userorder.enums.UserOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserOrderRepository extends JpaRepository<UserOrderEntity, Long> {

    //특정 유저의 모든 주문 가져오기
    //select * from user_order where user_id = ? and status = ? ORDER BY id DESC
    List<UserOrderEntity> findAllByUserIdAndStatusOrderByIdDesc(Long userId, UserOrderStatus status);

    //특정 주문 가져오기
    //select * from user_order where id = ? status = ? and user_id = ?
    Optional<UserOrderEntity> findAllByIdAndStatusAndUserId(Long id, UserOrderStatus status, Long userId);

    //특정 주문 가져오기(단, status 관계없이) => 상태값 없이 조회한다.
    //select * from user_order where id = ? and user_id = ?
    Optional<UserOrderEntity> findAllByIdAndUserId(Long id, Long userId);


    //특정 유저의 모든 주문 가져오기
    //select * from user_order where user_id = ? and status in (?, ? .. ) ORDER BY id DESC
    List<UserOrderEntity> findAllByUserIdAndStatusInOrderByIdDesc(Long userId, List<UserOrderStatus> status);


}
