package com.shoppingbackend.controller;
import com.shoppingbackend.dto.request.LoginRequest;
import com.shoppingbackend.dto.request.UserCreateRequest;
import com.shoppingbackend.dto.request.UserUpdateRequest;
import com.shoppingbackend.models.User;
import com.shoppingbackend.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthenticateController {
    @Autowired
    private IUserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        User user = userService.findByUserName(loginRequest.getUsername()).get();
        return new ResponseEntity<>(
              user, HttpStatus.OK);
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