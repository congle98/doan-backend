package com.shoppingbackend.services.author;

import com.shoppingbackend.models.Author;
import com.shoppingbackend.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author changeStatus(Long id) {
        Author author = authorRepository.findById(id).get();
        author.setActive(!author.isActive());
        return authorRepository.save(author);
    }

    @Override
    public Iterable<Author> findAllActive() {
        return authorRepository.findAllByActive(true);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
