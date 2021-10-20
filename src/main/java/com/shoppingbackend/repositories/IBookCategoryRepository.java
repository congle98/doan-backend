package com.shoppingbackend.repositories;
import com.shoppingbackend.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookCategoryRepository extends JpaRepository<BookCategory,Long> {
}
