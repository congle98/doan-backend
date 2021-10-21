package com.shoppingbackend.services.order;
import com.shoppingbackend.models.Order;
import java.util.Optional;

public interface IOrderService {
    Iterable<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    Order update(Order order);
    void delete(Long id);
}
