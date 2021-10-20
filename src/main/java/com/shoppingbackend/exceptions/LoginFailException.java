package com.shoppingbackend.exceptions;

public class LoginFailException extends Exception{
    public LoginFailException() {
        super("tài khoản hoặc mật khẩu không tồn tại");
    }

    public LoginFailException(String message) {
        super(message);
    }
}
