package com.shoppingbackend.repositories;
import com.shoppingbackend.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Image,Long> {
}