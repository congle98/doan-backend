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
    @PutMapping("")
    public ResponseEntity<Author> updateAuthor( @RequestBody Author author){
        return new ResponseEntity<>(authorService.update(author),HttpStatus.OK);
    }
}
