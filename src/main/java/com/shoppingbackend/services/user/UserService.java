package com.shoppingbackend.services.user;

import com.shoppingbackend.configs.MD5Library;
import com.shoppingbackend.dto.request.*;
import com.shoppingbackend.exceptions.*;
import com.shoppingbackend.models.Role;
import com.shoppingbackend.models.User;
import com.shoppingbackend.repositories.IUserRepository;
import com.shoppingbackend.services.email.EmailServiceImpl;
import com.shoppingbackend.services.email.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private EmailServiceImpl emailService;


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAllByRoleId(1l);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> login(LoginRequest loginRequest) throws Exception {
        String passwordEncoder = MD5Library.md5(loginRequest.getPassword());
        Optional<User> user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(),passwordEncoder);
        if(!user.isPresent()){
            throw new LoginFailException();
        }
        else if (!user.get().isStatus()){
            throw new AccountLockedException();
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User register(RegisterRequest userCreateRequest) throws Exception  {
        if(userRepository.findByUsername(userCreateRequest.getUsername()).isPresent()){
            throw new UserNameFoundException();
        }
        if(userRepository.findByEmail(userCreateRequest.getEmail()).isPresent()){
            throw new EmailFoundException();
        }
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setFullName(userCreateRequest.getUsername());
        user.setPhone(userCreateRequest.getPhone());
        user.setPassword(MD5Library.md5(userCreateRequest.getPassword()));
        user.setAvatarUrl("https://firebasestorage.googleapis.com/v0/b/doan-shopping.appspot.com/o/imgbin_samsung-galaxy-a8-a8-user-login-telephone-avatar-png.png?alt=media&token=3062b893-a590-44e4-b058-44695aca275e");
        Role role = new Role();
        role.setId(1L);
        user.setRole(role);
        emailService.registerEmail(user.getEmail(),user.getUsername());
        return userRepository.save(user);
    }
    @Override
    public User update(User userRq) throws Exception {
        User user = userRepository.findById(userRq.getId()).get();
        user.setEmail(userRq.getEmail());
        if(!userRepository.findByEmail(user.getEmail()).isPresent()){
            if(userRepository.findByEmail(user.getEmail()).get().getId() != user.getId()){
                throw new EmailFoundException();
            }
        }
        user.setFullName(userRq.getFullName());
        user.setAvatarUrl(userRq.getAvatarUrl());
        user.setPhone(userRq.getPhone());
        return userRepository.save(user);
    }

    @Override
    public User changeActive(Long id) {
        User user = userRepository.findById(id).get();
        user.setStatus(!user.isStatus());
        return userRepository.save(user);
    }

    @Override
    public User changePassword(ChangePasswordRequest request) throws Exception {
        User user = userRepository.findById(request.getId()).get();
        if(!user.getPassword().equals(MD5Library.md5(request.getOldPassword()))){
           throw new OldPasswordFoundException();
        }
        else {
            user.setPassword(MD5Library.md5(request.getNewPassword()));
            return userRepository.save(user);
        }
    }

    @Override
    public void resetPassword(ResetPasswordRequest request, HttpServletRequest http) throws Exception {
        Optional<User> user = userRepository.findByUsernameAndEmail(request.getUsername(),request.getEmail());
        if(!user.isPresent()){
            throw new UserNameOrEmailNotFoundException();
        }
        String newPassword = user.get().getEmail()+user.get().getUsername()+"123";
        user.get().setPassword(MD5Library.md5(newPassword));
//        String url = EmailUtils.getDomainName(http);
        userRepository.save(user.get());
        emailService.sendResetPassword(newPassword,user.get().getEmail(),user.get().getFullName());
    }
}
