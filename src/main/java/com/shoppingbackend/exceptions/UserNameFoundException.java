package com.shoppingbackend.exceptions;

public class UserNameFoundException extends Exception {
    public UserNameFoundException() {
        super("tài khoản đã tồn tại");
    }

    public UserNameFoundException(String message) {
        super(message);
    }
}
