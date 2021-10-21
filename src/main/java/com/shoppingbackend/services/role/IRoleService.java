package com.shoppingbackend.services.role;
import com.shoppingbackend.models.Role;
import java.util.Optional;

public interface IRoleService {
     Iterable<Role> findAll();
     Optional<Role> findById(Long id);
     Role save(Role role);
     Role update(Role role);
     void delete(Long id);
}
