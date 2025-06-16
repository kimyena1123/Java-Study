package org.delivery.storeadmin.domain.userordermenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.delivery.db.userordermenu.UserOrderMenuRepository;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserOrderMenuService {

    private final UserOrderMenuRepository userOrderMenuRepository;

    //userOrderId를 가지고 조회
    //하나의 주문(user_order)에 여러개의 상세메뉴(user_order_menu)가 있을 수 있기에 List 사용
    public List<UserOrderMenuEntity> getUserOrderMenuList(Long userOrderId){

        /*  조회하기(SELECT)
            사용자가 주문한 총내역에 대한 상세주문 보기
            ex)스터벅스 15,100원 주문했다면 -> 그 금액에 대한 상세 메뉴(아메리카노 1개, 카페라떼 2개)보기
            메뉴는 여러 개 있으므로 -> List 사용
            select * from user_order_menu where user_order_id = ? and status = ?
        */
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }
}
