package com.shoppingbackend.services.book;

import com.shoppingbackend.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    Book update(Book book);
    void delete(Long id);
    Page<Book> findAllByActive(Pageable pageable);
}
