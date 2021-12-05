package com.shoppingbackend.exceptions;

public class PhoneNumberFoundException extends Exception{
    public PhoneNumberFoundException() {
        super("Xin lỗi số điện thoại đã tồn tại!");
    }

    public PhoneNumberFoundException(String message) {
        super(message);
    }
}
