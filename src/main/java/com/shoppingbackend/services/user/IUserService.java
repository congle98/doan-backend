package com.shoppingbackend.services.user;
import com.shoppingbackend.dto.request.*;
import com.shoppingbackend.exceptions.EmailFoundException;
import com.shoppingbackend.exceptions.OldPasswordFoundException;
import com.shoppingbackend.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
    void delete(Long id);
    Optional<User> login(LoginRequest loginRequest) throws Exception;
    User register(RegisterRequest userCreateRequest) throws Exception;
    User update(User userRq) throws Exception;
    User changeActive(Long id);
    User changePassword(ChangePasswordRequest request) throws Exception;
    void resetPassword(ResetPasswordRequest request, HttpServletRequest http) throws Exception;

}
