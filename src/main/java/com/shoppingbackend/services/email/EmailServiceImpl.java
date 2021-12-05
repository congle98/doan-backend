package com.shoppingbackend.services.email;

import com.shoppingbackend.models.User;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.shoppingbackend.models.Order;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class EmailServiceImpl implements EmailSender{
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendResetPassword(String password,String email,String username) throws UnsupportedEncodingException, MessagingException {
        String subject = "Congle Store Lấy lại mật khẩu";
        String senderName = "Quản trị viên";
        String mailContent = "<h3>Xin chào <strong>"+ username+"</strong> !</h3>";
        mailContent += "<p>Mật khẩu của bạn đã được thiết lập lại là: <strong>"+password+"</strong></p>";
        mailContent += "<p>Hãy lưu lại mật khẩu và đảm bảo rằng bạn không chia sẻ nó cho bất kỳ ai</p>";
        mailContent += "<h3>Quay lại Congle Store và bắt đầu mua sắm https://conglestore.netlify.app </h3>";
        mailContent += "<h2>Cảm ơn bạn<br>Congle Store</h2>";

        MimeMessage message = mailSender.createMimeMessage();
        message.setContent(mailContent,"text/html; charset=UTF-8");
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("conglestore@gmail.com",senderName);
        helper.setTo(email);
        helper.setSubject(subject);

        mailSender.send(message);
    }

    @Override
    public void registerEmail(String email, String username) throws UnsupportedEncodingException, MessagingException {
        String subject = "Congle Store Đăng ký thành công";
        String senderName = "Quản trị viên";
        String mailContent = "<h3>Xin chào <strong>"+ username+"</strong> !</h3>";
        mailContent += "<p>Bạn đã đăng ký tài khoản thành công, chào mừng bạn đến với Congle Store</p>";
        mailContent += "<h3>Quay lại Congle Store và bắt đầu mua sắm https://conglestore.netlify.app </h3>";
        MimeMessage message = mailSender.createMimeMessage();
        message.setContent(mailContent,"text/html; charset=UTF-8");
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("conglestore@gmail.com",senderName);
        helper.setTo(email);
        helper.setSubject(subject);

        mailSender.send(message);
    }

    @Override
    public void acceptOrder(String email, String username,String orderNumber) throws UnsupportedEncodingException, MessagingException {
        String subject = "Congle Store xác nhận đơn hàng";
        String senderName = "Quản trị viên";
        String mailContent = "<h3>Xin chào <strong>"+ username+"</strong> !</h3>";
        mailContent += "<p>Đơn hàng mã: "+orderNumber+" của bạn đã được xác nhận</p>";
        mailContent += "<h3>Quay lại Congle Store và bắt đầu mua sắm https://conglestore.netlify.app </h3>";
        mailContent += "<h3>Mọi thông tin xin vui lòng liên hệ : 0342910909 hoặc email: lethanhcongcnhn@gmail.com</h3>";
        MimeMessage message = mailSender.createMimeMessage();
        message.setContent(mailContent,"text/html; charset=UTF-8");
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("conglestore@gmail.com",senderName);
        helper.setTo(email);
        helper.setSubject(subject);

        mailSender.send(message);
    }

    @Override
    public void cancelOrder(String email, String username,String orderNumber) throws UnsupportedEncodingException, MessagingException {
        String subject = "Congle Store huỷ đơn hàng";
        String senderName = "Quản trị viên";
        String mailContent = "<h3>Xin chào <strong>"+ username+"</strong> !</h3>";
        mailContent += "<p>Đơn hàng mã: "+orderNumber+" của bản đã không được chấp nhận</p>";
        mailContent += "<h3>Quay lại Congle Store và bắt đầu mua sắm https://conglestore.netlify.app </h3>";
        mailContent += "<h3>Mọi thông tin xin vui lòng liên hệ : 0342910909 hoặc email: lethanhcongcnhn@gmail.com</h3>";
        MimeMessage message = mailSender.createMimeMessage();
        message.setContent(mailContent,"text/html; charset=UTF-8");
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("conglestore@gmail.com",senderName);
        helper.setTo(email);
        helper.setSubject(subject);
    }
}
