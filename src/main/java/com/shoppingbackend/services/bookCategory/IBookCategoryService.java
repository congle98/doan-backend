package com.shoppingbackend.services.bookCategory;

import com.shoppingbackend.models.Book;
import com.shoppingbackend.models.BookCategory;

import java.util.Optional;

public interface IBookCategoryService {
    Iterable<BookCategory> findAll();
    Optional<BookCategory> findById(Long id);
    BookCategory save(BookCategory bookCategory);
    BookCategory update(BookCategory bookCategory);
    void delete(Long id);
}
