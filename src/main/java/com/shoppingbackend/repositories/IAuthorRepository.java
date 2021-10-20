package com.shoppingbackend.repositories;
import com.shoppingbackend.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
