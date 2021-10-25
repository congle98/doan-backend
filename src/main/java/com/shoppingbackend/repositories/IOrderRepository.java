package com.shoppingbackend.repositories;
import com.shoppingbackend.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    Iterable<Order> findAllByCustomerIdOrderByDateCreatedDesc(Long id);
}
