package com.shoppingbackend.exceptions;

public class OldPasswordFoundException extends Exception{
    public OldPasswordFoundException() {
        super("Mật khẩu hiện tại không chính xác!");
    }

    public OldPasswordFoundException(String message) {
        super(message);
    }
}
