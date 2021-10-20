package com.shoppingbackend.services.user;
import com.shoppingbackend.dto.request.UserCreateRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.exceptions.EmailFoundException;
import com.shoppingbackend.exceptions.UserNameFoundException;
import com.shoppingbackend.models.Role;
import com.shoppingbackend.models.User;
import com.shoppingbackend.repositories.IUserRepository;
import com.shoppingbackend.services.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IRoleService roleService;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
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
    public User register(UserCreateRequest userCreateRequest) throws Exception  {
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
        user.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        Role role = new Role();
        role.setId(1L);
        user.setRole(role);
        return userRepository.save(user);
    }
    @Override
    public User update(UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(userUpdateRequest.getId()).get();
        user.setPassword(bCryptPasswordEncoder.encode(userUpdateRequest.getPassword()));
        return userRepository.save(user);
    }


}
