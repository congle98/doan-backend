package com.shoppingbackend.controller;

import com.shoppingbackend.models.User;
import com.shoppingbackend.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
