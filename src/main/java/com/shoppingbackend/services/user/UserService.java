package com.shoppingbackend.services.user;

import com.shoppingbackend.configs.MD5Library;
import com.shoppingbackend.dto.request.LoginRequest;
import com.shoppingbackend.dto.request.RegisterRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.exceptions.AccountLockedException;
import com.shoppingbackend.exceptions.EmailFoundException;
import com.shoppingbackend.exceptions.LoginFailException;
import com.shoppingbackend.exceptions.UserNameFoundException;
import com.shoppingbackend.models.Role;
import com.shoppingbackend.models.User;
import com.shoppingbackend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;


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
        return userRepository.save(user);
    }
    @Override
    public User update(User userRq){
        User user = userRepository.findById(userRq.getId()).get();
        user.setEmail(userRq.getEmail());
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
}
