package com.shoppingbackend.controller;

import com.shoppingbackend.dto.request.ChangePasswordRequest;
import com.shoppingbackend.dto.request.ResetPasswordRequest;
import com.shoppingbackend.models.User;
import com.shoppingbackend.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/change-active")
    public ResponseEntity<User> changeStatus(@RequestBody Long id){
        return new ResponseEntity<>(userService.changeActive(id),HttpStatus.OK);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<User> updateProfile(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user),HttpStatus.OK);
    }
    @PutMapping("/change-password")
    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordRequest request) throws Exception {
        return new ResponseEntity<>(userService.changePassword(request),HttpStatus.OK);
    }
    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordRequest request, HttpServletRequest http) throws Exception {
        userService.resetPassword(request,http);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public  ResponseEntity<?> exceptionHandler(Exception ex){
        return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
    }
}
