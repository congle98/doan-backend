package com.shoppingbackend.exceptions;

public class EmailFoundException extends Exception{
    public EmailFoundException() {
        super("Xin lỗi email đã tồn tại !");
    }

    public EmailFoundException(String message) {
        super(message);
    }
}
