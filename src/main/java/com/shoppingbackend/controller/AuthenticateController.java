package com.shoppingbackend.controller;

import com.shoppingbackend.configs.JwtUtil;
import com.shoppingbackend.dto.request.JwtRequest;
import com.shoppingbackend.dto.request.UserCreateRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.dto.response.JwtResponse;
import com.shoppingbackend.exceptions.EmailFoundException;
import com.shoppingbackend.exceptions.UserFoundException;
import com.shoppingbackend.models.Role;
import com.shoppingbackend.models.User;
import com.shoppingbackend.services.role.IRoleService;
import com.shoppingbackend.services.user.IUserService;
import com.shoppingbackend.services.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        //thêm đối tượng này vào secutiry để xử lý tiếp
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //khởi tạo jwt từ đối tượng này
        String jwt = jwtUtil.generateJwtToken(authentication);
        //tạo đối tượng userdetail từ authen.getPrincipal
        System.out.println("jwt là "+jwt);


        return new ResponseEntity<>(
                new JwtResponse(jwt), HttpStatus.OK);


    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){

        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserCreateRequest userRequestCreate) throws Exception {
        User userRp = userService.save(userRequestCreate);
        return new ResponseEntity<>(userRp, HttpStatus.CREATED);



    }
    @PutMapping("/update")
    public ResponseEntity<?>updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        return new ResponseEntity<>(userService.update(userUpdateRequest),HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public  ResponseEntity<?> exceptionHandler(Exception ex){
        return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
    }
}
