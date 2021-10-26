package com.shoppingbackend.exceptions;

public class AccountLockedException extends Exception {
    public AccountLockedException() {
        super("Tài khoản của bạn đã bị khóa, vui lòng liên hệ Admin để mở: 0342910909");
    }

    public AccountLockedException(String message) {
        super(message);
    }
}
