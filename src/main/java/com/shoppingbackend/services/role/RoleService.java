package com.shoppingbackend.services.role;

import com.shoppingbackend.models.Role;
import com.shoppingbackend.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

    }



    @Override
    public Role save(Role role) {
        return null;
    }
}
