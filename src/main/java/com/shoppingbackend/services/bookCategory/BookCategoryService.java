package com.shoppingbackend.services.bookCategory;

import com.shoppingbackend.models.BookCategory;
import com.shoppingbackend.repositories.IBookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookCategoryService implements IBookCategoryService {
    @Autowired
    private IBookCategoryRepository bookCategoryRepository;
    @Override
    public Iterable<BookCategory> findAll() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public Optional<BookCategory> findById(Long id) {
        return bookCategoryRepository.findById(id);
    }

    @Override
    public BookCategory save(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory update(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public void delete(Long id) {
        bookCategoryRepository.deleteById(id);
    }
}
