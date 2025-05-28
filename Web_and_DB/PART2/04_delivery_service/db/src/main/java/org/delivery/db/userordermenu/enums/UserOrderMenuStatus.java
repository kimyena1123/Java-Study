package org.delivery.db.userordermenu.enums;

public enum UserOrderMenuStatus {

    REGISTERED("등록"),
    UNREGISTERD("해지"),
    ;

    UserOrderMenuStatus(String description) {
        this.description = description;
    }

    private String description;
}
