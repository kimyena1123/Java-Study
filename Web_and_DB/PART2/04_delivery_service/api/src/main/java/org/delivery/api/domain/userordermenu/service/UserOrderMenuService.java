package org.delivery.api.domain.userordermenu.service;

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

    // user order menu를 가져오는 건 특정 id로 가져오지 않고(즉, user_order_menu 테이블의 id로 가져오는 게 아니라), 그 상위에 있는
    //user_order 테이블(주문 내역)에서 가져온다. userordermenuId를 가져오는게 아니라 userorderId를 가져온다.
    public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId){ //주문내역에 주문이 여러 개 존재 -> list 사용

        //null이 있을 수 있다.
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }
}
