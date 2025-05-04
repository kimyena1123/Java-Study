package org.delivery.api.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.store.business.StoreBusiness;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.db.store.enums.StoreCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@RequiredArgsConstructor
public class StoreApiController { //가맹점 등록(register)는 로그인한 사용자가 등록하는게 아니라, 가맹점 직원들이 등록하는 것이기 때문에, StoreOpneApiControlelr에 위치

    private final StoreBusiness storeBusiness;

    @GetMapping("/search")
    public Api<List<StoreResponse>> search(
            @RequestParam(required = false) //필수값 아님(즉, null 가능)
            StoreCategory storeCategory
    ){
        var response = storeBusiness.searchCategory(storeCategory);

        return Api.OK(response);
    }
}
