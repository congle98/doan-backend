package com.shoppingbackend.exceptions;

public class AccountLockedException extends Exception {
    public AccountLockedException() {
        super("Tài khoản của bạn đã bị khóa !");
    }

    public AccountLockedException(String message) {
        super(message);
    }
}
