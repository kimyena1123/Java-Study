package org.delivery.api.domain.userordermenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.delivery.db.userordermenu.UserOrderMenuRepository;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserOrderMenuService {

    private final UserOrderMenuRepository userOrderMenuRepository;

    /*  추가하기(INSERT): 주문 메뉴를 등록하기. 사용자가 주문하면 user_order과 user_order_menu에 추가된다
        사용자가 주문한 한 가게에 대한 여러 메뉴 주문을 user_order_menu 테이블에 추가하기(
        ex)스터벅스 15,100원 주문했다면 -> 그 금액에 대한 상세 메뉴(아메리카노 1개, 카페라떼 2개) 테이블에 추가하기
        단, 3개의 메뉴를 시켰다고 했을 때, 한번에 3개 메뉴를 추가하는게 아니라, "하나씩(한 행씩)" 추가되는 구조이다.
            => 어떻게? user_order(UserOrderBusiness에서)에서 주문내역을 저장(insert)할 때,
                주문내역의 상세 메뉴들을 해당 아래 order() 메소드를 호출해서 user_order_menu에 추가할 것임
        INSERT INTO user_order_menu (user_order_id, store_menu_id, status) VALUE (?, ?, REGISTERED)
    */
    public UserOrderMenuEntity order(UserOrderMenuEntity userOrderMenuEntity){
        return Optional.ofNullable(userOrderMenuEntity)
                .map(it -> {
                    it.setStatus(UserOrderMenuStatus.REGISTERED); //user_order_menu의 status 값으로 REGISTERED로 지정
                    return userOrderMenuRepository.save(it);
                }).orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    /*  조회하기(SELECT): 사용자가 주문한 내역의 상세 메뉴 보기
        사용자가 주문한 총내역에 대한 상세주문 보기
        ex)스터벅스 15,100원 주문했다면 -> 그 금액에 대한 상세 메뉴(아메리카노 1개, 카페라떼 2개) 보기
        메뉴는 여러 개 있으므로 -> List 사용
        select * from user_order_menu where user_order_id = ? and status = ?
    */
    public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId){ //주문내역에 주문이 여러 개 존재 -> list 사용

        //null이 있을 수 있다.
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }


}
