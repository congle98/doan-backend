package com.shoppingbackend.services.orderStatus;

import com.shoppingbackend.models.Order;
import com.shoppingbackend.models.OrderStatus;

import java.util.Optional;

public interface IOrderStatusService {
    Iterable<OrderStatus> findAll();
    Optional<OrderStatus> findById(Long id);
    OrderStatus save(OrderStatus orderStatus);
    OrderStatus update(OrderStatus orderStatus);
    void delete(Long id);
}
