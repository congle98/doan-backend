package com.shoppingbackend.controller;

import com.shoppingbackend.models.Author;
import com.shoppingbackend.services.author.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping("")
    public ResponseEntity<Iterable<Author>> findAllAuthor(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAllActive")
    public ResponseEntity<Iterable<Author>> findAllActive(){
        return new ResponseEntity<>(authorService.findAllActive(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        System.out.println(author+"dsfsdfsdfds");
        return new ResponseEntity<>(authorService.save(author),HttpStatus.OK);
    }
    @PutMapping("/change-status")
    public ResponseEntity<Author> changeStatus(@RequestBody Long id){
        return new ResponseEntity<>(authorService.changeStatus(id),HttpStatus.OK);
    }
}
