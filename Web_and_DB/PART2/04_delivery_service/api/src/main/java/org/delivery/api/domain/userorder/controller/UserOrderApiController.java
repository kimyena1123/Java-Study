package org.delivery.api.domain.userorder.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.UserSession;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.user.model.User;
import org.delivery.api.domain.userorder.business.UserOrderBusiness;
import org.delivery.api.domain.userorder.model.UserOrderDetailResponse;
import org.delivery.api.domain.userorder.model.UserOrderRequest;
import org.delivery.api.domain.userorder.model.UserOrderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-order")
@RequiredArgsConstructor
public class UserOrderApiController {

    private final UserOrderBusiness userOrderBusiness;

    /*  사용자 주문(CREATE)
        ex) 사용자가 스타벅스에서 아메리카노 1잔, 카페라떼 2잔 주문 -> 해당 주문으로 user_order 테이블에 추가(insert)한다
            user_order 테이블에 추가되는 과정에서 상세 메뉴도 user_order_menu 테이블에 추가하는 과정이 있을 것암
        사용자의 주문(요청) request를 받아 해당 내용이 DB에 저장된 후, 다시 사용자에게 응답 Response를 보낸다.
        해당 주문은
     */
    @PostMapping("") //localhost:8080/api/user-order
    public Api<UserOrderResponse> userOrder(
            @Valid
            @RequestBody Api<UserOrderRequest> userOrderRequest, //request는 사용자가 주문하고 싶은 메뉴 여러 개가 담겨있다(store_menu id 여러개가 담겨있다.)

            @Parameter(hidden = true)
            @UserSession  User user
    ){
        var response = userOrderBusiness.userOrder(user, userOrderRequest.getBody());

        return Api.OK(response);
    }

    /* 현재 진행중인 주문 보기(SELECT)
        SELECT * FROM user_order WHERE status IN (ORDER, ACCEPT, COOKING, DELIVERY, RECEIVE) AND user_id = ?
        * 현재 진행중인 주문이 여러 개 있을 수 있다! => List
    */
    @GetMapping("/current")
    public Api<List<UserOrderDetailResponse>> current(
            @Parameter(hidden = true)
            @UserSession  User user
    ){ // 로그인한 사용자만 필요하다.
        var response = userOrderBusiness.current(user);

        return Api.OK(response);
    }

    /* 과거 주문한 내역 보기(SELECT)
     * 과거 주문이 여러 개 있을 수 있다! => List
     */
    @GetMapping("/history")
    public Api<List<UserOrderDetailResponse>> history(
            @Parameter(hidden = true)
            @UserSession  User user
    ) {
        var response = userOrderBusiness.history(user);
        return Api.OK(response);
    }

    /* 주문 1건에 대한 내역 보기(SELECT)
    select * from user_order where id = ? status = ? and user_id = ?
    */
    @GetMapping("/id/{orderId}")
    public Api<UserOrderDetailResponse> read(
            @Parameter(hidden = true)
            @UserSession User user,

            @PathVariable Long orderId
    ){
        var response = userOrderBusiness.read(user, orderId);

        return Api.OK(response);
    }
}
