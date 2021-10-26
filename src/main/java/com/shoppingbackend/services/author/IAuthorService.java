package com.shoppingbackend.services.author;

import com.shoppingbackend.models.Author;
import com.shoppingbackend.models.Book;

import java.util.Optional;

public interface IAuthorService {
    Iterable<Author> findAll();
    Iterable<Author> findAllActive();
    Optional<Author> findById(Long id);
    Author save(Author author);
    Author update(Author author);
    void delete(Long id);
    Author changeStatus(Long id);
}
