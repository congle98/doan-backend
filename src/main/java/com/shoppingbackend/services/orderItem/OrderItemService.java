package com.shoppingbackend.services.orderItem;

import com.shoppingbackend.models.OrderItem;
import com.shoppingbackend.repositories.IOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepository orderItemRepository;
    @Override
    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}
