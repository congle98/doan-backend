package com.shoppingbackend.services.user;
import com.shoppingbackend.dto.request.UserCreateRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.models.User;
import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void delete(Long id);
    User register(UserCreateRequest userCreateRequest) throws Exception;
    User update(UserUpdateRequest userUpdateRequest);
}
