package com.shoppingbackend.services.email;

import com.shoppingbackend.models.Order;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailSender {
    void sendResetPassword(String password,String email,String username) throws UnsupportedEncodingException, MessagingException;
    void registerEmail(String email,String username) throws UnsupportedEncodingException, MessagingException;
    void acceptOrder(String email,String username,String orderNumber) throws UnsupportedEncodingException, MessagingException;
    void cancelOrder(String email,String username,String orderNumber) throws UnsupportedEncodingException, MessagingException;
}

