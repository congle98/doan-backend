package com.shoppingbackend.exceptions;

public class AccountLockedException extends Exception {
    public AccountLockedException() {
        super("tài khoản đã bị khóa");
    }

    public AccountLockedException(String message) {
        super(message);
    }
}
