package com.shoppingbackend.services.order;
import com.shoppingbackend.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {
    Iterable<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    Order update(Order order);
    void delete(Long id);
    Iterable<Order> getAllByCustomer(Long id);
    Order changeOrderStatus(Long id, Long statusId) throws Exception;
}
