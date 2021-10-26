package com.shoppingbackend.exceptions;

public class UserNameFoundException extends Exception {
    public UserNameFoundException() {
        super("Xin lỗi tên tài khoản đã tồn tại !");
    }

    public UserNameFoundException(String message) {
        super(message);
    }
}
