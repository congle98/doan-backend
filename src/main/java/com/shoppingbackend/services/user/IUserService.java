package com.shoppingbackend.services.user;
import com.shoppingbackend.dto.request.LoginRequest;
import com.shoppingbackend.dto.request.RegisterRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.models.User;
import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
    void delete(Long id);
    Optional<User> login(LoginRequest loginRequest) throws Exception;
    User register(RegisterRequest userCreateRequest) throws Exception;
    User update(UserUpdateRequest userUpdateRequest);

}
