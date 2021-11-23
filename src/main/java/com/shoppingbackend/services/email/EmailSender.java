package com.shoppingbackend.services.email;


import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailSender {
    void sendResetPassword(String password,String email,String username) throws UnsupportedEncodingException, MessagingException;
    void registerEmail(String email,String username) throws UnsupportedEncodingException, MessagingException;
}

