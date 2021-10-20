package com.shoppingbackend.services.role;
import com.shoppingbackend.models.Role;
import java.util.Optional;

public interface IRoleService {
     Iterable<Role> findAll();
     Optional<Role> findById(Long id);
     void delete(Long id);
     Role save(Role role);
}
