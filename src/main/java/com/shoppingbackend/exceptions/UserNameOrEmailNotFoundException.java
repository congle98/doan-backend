package com.shoppingbackend.exceptions;

public class UserNameOrEmailNotFoundException extends Exception {
    public UserNameOrEmailNotFoundException() {
        super("Tài khoản hoặc email không tồn tại!");
    }

    public UserNameOrEmailNotFoundException(String message) {
        super(message);
    }
}
