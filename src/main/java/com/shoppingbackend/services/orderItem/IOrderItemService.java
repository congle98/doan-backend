package com.shoppingbackend.services.orderItem;
import com.shoppingbackend.models.OrderItem;
import java.util.Optional;
public interface IOrderItemService {
    Iterable<OrderItem> findAll();
    Optional<OrderItem> findById(Long id);
    OrderItem save(OrderItem orderItem);
    OrderItem update(OrderItem orderItem);
    void delete(Long id);
}
