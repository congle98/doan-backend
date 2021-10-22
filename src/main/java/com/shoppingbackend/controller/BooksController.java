package com.shoppingbackend.controller;

import com.shoppingbackend.models.Book;
import com.shoppingbackend.services.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
@RestController
public class BooksController {
    @Autowired
    private IBookService bookService;


    @GetMapping("/findAllActive")
    public ResponseEntity<Page<Book>> findAllActive (@RequestParam Long id, @RequestParam Integer page, @RequestParam Integer size ){
        Pageable pageable = PageRequest.of(page,size);
        Page<Book> booksPage;
        if(id != 0){
            booksPage = bookService.finAllByActiveAndCategoryId(id,pageable);
        }
        else {
            booksPage = bookService.findAllByActive(pageable);
        }
        return new ResponseEntity<>(booksPage, HttpStatus.OK);
    }
    @GetMapping("/search/findByContextContaining")
    public ResponseEntity<Page<Book>> findAllByContextContaining(@RequestParam String context, @RequestParam Integer page, @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Book> bookPage = bookService.findAllByContextContaining(context,pageable);
        System.out.println(bookPage);
        return new ResponseEntity<>(bookPage,HttpStatus.OK);
    }

}
