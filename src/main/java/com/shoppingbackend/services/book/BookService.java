package com.shoppingbackend.services.book;

import com.shoppingbackend.models.Book;
import com.shoppingbackend.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllByActive(Pageable pageable) {
        return bookRepository.findAllByActive(true,pageable);
    }

    @Override
    public Page<Book> findAllByContextContaining(String context, Pageable pageable) {
        return bookRepository.findAllByActiveAndNameContainingOrBookCategoryNameContainingOrAuthorNameContaining(true,context,context,context,pageable);
    }

    @Override
    public Page<Book> finAllByActiveAndCategoryId(Long id, Pageable pageable) {
        return bookRepository.findAllByActiveAndBookCategoryId(true,id,pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        if(book.getImageUrl().trim().equals("") || book.getImageUrl() == null){
            book.setImageUrl("https://cdn1.vectorstock.com/i/1000x1000/77/85/closed-old-book-in-brown-cover-vector-9187785.jpg");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book changeStatus(Long id) {
        Book book = bookRepository.getById(id);
        book.setActive(!book.isActive());
        return bookRepository.save(book);
    }
}
