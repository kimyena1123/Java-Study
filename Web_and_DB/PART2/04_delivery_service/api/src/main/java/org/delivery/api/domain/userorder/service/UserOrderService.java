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
    public List<UserOrderEntity> getUserOrderList(Long userId){

        return userOrderRepository.findAllByUserIdAndStatusOrderByIdDesc(userId, UserOrderStatus.REGISTERED);
    }

    //특정 주문 가져오기
    public UserOrderEntity getUserOrderWithThrow(Long id, Long userId){

        return userOrderRepository.findAllByIdAndStatusAndUserId(id, UserOrderStatus.REGISTERED, userId)
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    public List<UserOrderEntity> getUserOrderList(Long userId, List<UserOrderStatus> statusList){

        return userOrderRepository.findAllByUserIdAndStatusInOrderByIdDesc(userId, statusList);
    }

    //현재 진행중인 내역
    public List<UserOrderEntity> current(Long userId){
        return getUserOrderList(
                userId,
                List.of(UserOrderStatus.ORDER, UserOrderStatus.COOKING, UserOrderStatus.DELIVERY, UserOrderStatus.ACCEPT)
        );
    }

    //과거에 내가 주문했던 내역
    public List<UserOrderEntity> history(Long userId){
        return getUserOrderList(
                userId,
                List.of(UserOrderStatus.RECEIVE)
        );
    }

    //주문(create)
    public UserOrderEntity order(UserOrderEntity userOrderEntity){
        return Optional.ofNullable(userOrderEntity)
                .map(it -> {
                    it.setStatus(UserOrderStatus.ORDER);
                    it.setOrderedAt(LocalDateTime.now());

                    return userOrderRepository.save(it);
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    //주문 확인, 조리 시작, 배달 시작 => 상태 변경임 => 그래서 각각 메소드를 만들기 보다는 하나의 메소드를 만들어서 그걸 사용
    //상태 변경 메소드
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
