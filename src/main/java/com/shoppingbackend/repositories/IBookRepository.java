package com.shoppingbackend.repositories;
import com.shoppingbackend.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByActive(Boolean active,Pageable pageable);
    Page<Book> findAllByActiveAndNameContainingOrBookCategoryNameContainingOrAuthorNameContaining(Boolean active,String name,String categoryName,String authorName,Pageable pageable);
    Page<Book> findAllByActiveAndBookCategoryId(Boolean active, Long id, Pageable pageable);
}
