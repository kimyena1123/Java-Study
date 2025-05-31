package org.delivery.api.domain.userorder.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userorder.UserOrderRepository;
import org.delivery.db.userorder.enums.UserOrderStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;

    //특정 사용자의 모든 주문 내역 가져오기
    //SELECT * FROM user_order WHERE user_id = ? AND status = ? ORDER BY id DESC
    public List<UserOrderEntity> getUserOrderList(Long userId){

        return userOrderRepository.findAllByUserIdAndStatusOrderByIdDesc(userId, UserOrderStatus.REGISTERED);
    }


    //특정 주문 가져오기
    //SELECT * FROM user_order WHERE id = ? AND status = ? AND user_id = ?
    public UserOrderEntity getUserOrderWithThrow(Long id, Long userId){

        //상태가 REGISTERED인 것만 보여준다. 그래서 주문이 ORDER이거나 COOKING 등의 상태이면 보여주지 않는다.
        return userOrderRepository.findAllByIdAndStatusAndUserId(id, UserOrderStatus.REGISTERED, userId)
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    //REGISTERED인 상태만 보여주기에, 다른 상태일 때도 볼 수 있도록 하는 메소드
    public UserOrderEntity getUserOrderWithOutStatusWithThrow(Long id, Long userId){
        return userOrderRepository.findAllByIdAndUserId(id, userId)
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    // ========================= Status 상태에 따른 주문 내역 가져오기  =========================
    //SELECT * FROM user_order WHERE user_id = ? AND status in (?, ? .. ) ORDER BY id DESC
    public List<UserOrderEntity> getUserOrderList(Long userId, List<UserOrderStatus> statusList){

        return userOrderRepository.findAllByUserIdAndStatusInOrderByIdDesc(userId, statusList);
    }

    //현재 진행중인 내역
    //SELECT * FROM user_order WHERE status IN (ORDER, COOKING, DELIVERY)
    public List<UserOrderEntity> current(Long userId){
        return getUserOrderList(
                userId,
                List.of(UserOrderStatus.ORDER, UserOrderStatus.COOKING, UserOrderStatus.DELIVERY, UserOrderStatus.ACCEPT)
        );
    }

    //과거에 내가 주문했던 내역
    //SELECT * FROM user_order WHERE status = RECEIVE
    public List<UserOrderEntity> history(Long userId){
        return getUserOrderList(
                userId,
                List.of(UserOrderStatus.RECEIVE)
        );
    }
    // ========================= Status 상태에 따른 주문 내역 가져오기  end =========================


    //주문(create)
    public UserOrderEntity order(UserOrderEntity userOrderEntity){
        return Optional.ofNullable(userOrderEntity)
                .map(it -> {
                    it.setStatus(UserOrderStatus.ORDER);
                    it.setOrderedAt(LocalDateTime.now());

                    return userOrderRepository.save(it);
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }


    // ========================= user_order 테이블 상태 정보 변경 (UPDATE) =========================
    // 이미 insert 되어 있는 user_order 정보에 주문확인, 조리 시작, 배달 시작, 음식받기 완료와 같은 상태를 UPDATE 한다
    //주문 확인, 조리 시작, 배달 시작 => 상태 변경임 => 그래서 각각 메소드를 만들기 보다는 하나의 메소드를 만들어서 그걸 사용
    public UserOrderEntity setStatus(UserOrderEntity userOrderEntity, UserOrderStatus status){
        userOrderEntity.setStatus(status);

        return userOrderRepository.save(userOrderEntity);
    }


    //주문 확인(상태를 바꿔줌)
    public UserOrderEntity accept(UserOrderEntity userOrderEntity){
        userOrderEntity.setAcceptedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.ACCEPT);
    }

    //조리 시작(상태를 바꿔줌)
    public UserOrderEntity cooking(UserOrderEntity userOrderEntity){
        userOrderEntity.setCookingStartedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.COOKING);
    }

    //배달 시작(상태를 바꿔줌)
    public UserOrderEntity delivery(UserOrderEntity userOrderEntity){
        userOrderEntity.setDeliveryStartedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.DELIVERY);
    }

    //배달 완료
    public UserOrderEntity receive(UserOrderEntity userOrderEntity){
        userOrderEntity.setReceivedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.RECEIVE);
    }

}
