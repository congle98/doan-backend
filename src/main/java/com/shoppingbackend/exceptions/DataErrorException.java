package com.shoppingbackend.exceptions;

public class DataErrorException extends Exception{
    public DataErrorException() {
        super("Dữ liệu trước đó đã được cập nhật, vui lòng tải lại trang !");
    }

    public DataErrorException(String message) {
        super(message);
    }
}
