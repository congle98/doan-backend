package com.shoppingbackend.repositories;
import com.shoppingbackend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<Address,Long> {
}
