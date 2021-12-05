package com.shoppingbackend.controller;

import com.shoppingbackend.models.Book;
import com.shoppingbackend.services.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
@RestController
public class BooksController {
    @Autowired
    private IBookService bookService;


    @GetMapping("/findAllActive")
    public ResponseEntity<Page<Book>> findAllActive (@RequestParam Long id, @RequestParam Integer page, @RequestParam Integer size, @RequestParam String sort ){
        Sort sortList = Sort.by(
                Sort.Order.asc("name")
        );
        if(sort.equals("namedesc")){
            sortList = Sort.by(
                    Sort.Order.desc("name")
            );
        }
        if(sort.equals("priceasc")){
            sortList = Sort.by(
                    Sort.Order.asc("unitPrice")
            );
        }
        if(sort.equals("pricedesc")){
            sortList = Sort.by(
                    Sort.Order.desc("unitPrice")
            );
        }
        Pageable pageable = PageRequest.of(page,size,sortList);
        Page<Book> booksPage;
        if(id != 0){
            booksPage = bookService.findAllByActiveAndCategoryId(id,pageable);
        }
        else {
            booksPage = bookService.findAllByActive(pageable);
        }
        return new ResponseEntity<>(booksPage, HttpStatus.OK);
    }
    @GetMapping("/search/findByContextContaining")
    public ResponseEntity<Page<Book>> findAllByContextContaining(@RequestParam String context, @RequestParam Integer page, @RequestParam Integer size, @RequestParam String sort) {
        Sort sortList = Sort.by(
                Sort.Order.asc("name")
        );
        if(sort.equals("namedesc")){
            sortList = Sort.by(
                    Sort.Order.desc("name")
            );
        }
        if(sort.equals("priceasc")){
            sortList = Sort.by(
                    Sort.Order.asc("unitPrice")
            );
        }
        if(sort.equals("pricedesc")){
            sortList = Sort.by(
                    Sort.Order.desc("unitPrice")
            );
        }
        Pageable pageable = PageRequest.of(page,size,sortList);
        Page<Book> bookPage = bookService.findAllByContextContaining(context,pageable);
        System.out.println(bookPage);
        return new ResponseEntity<>(bookPage,HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<Iterable<Book>> findAllByAdmin(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }
    @PutMapping("/change-status")
    public ResponseEntity<Book> changeStatus(@RequestBody Long bookId){
        return new ResponseEntity<>(bookService.changeStatus(bookId),HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book),HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.update(book),HttpStatus.OK);
    }

    @GetMapping("/top-sale")
    public ResponseEntity<Iterable<Book>> topSale(){
        return new ResponseEntity<>(bookService.findAllTopSale(),HttpStatus.OK);
    }
    @GetMapping("/top-sold")
    public ResponseEntity<Iterable<Book>> topSold(){
        return new ResponseEntity<>(bookService.findAllTopSold(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findById(id).get(),HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Book>> getByCategory(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findAllByCategory(id),HttpStatus.OK);
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<Iterable<Book>> getByAuthor(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findAllByAuthor(id),HttpStatus.OK);
    }


}
