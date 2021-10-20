package com.shoppingbackend.services.user;


import com.shoppingbackend.dto.request.UserCreateRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.models.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUserName(String name);
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void delete(Long id);
    User save(UserCreateRequest userCreateRequest);
    User update(UserUpdateRequest userUpdateRequest);

}
