package com.shoppingbackend.controller;
import com.shoppingbackend.models.BookCategory;
import com.shoppingbackend.services.bookCategory.IBookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/categories")
@RestController
public class CategoriesController {
    @Autowired
    private IBookCategoryService bookCategoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<BookCategory>> findAllCategories() {
        return new ResponseEntity<>(bookCategoryService.findAll(), HttpStatus.OK);
    }

}
