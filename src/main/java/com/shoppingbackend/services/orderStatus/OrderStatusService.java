package com.shoppingbackend.services.orderStatus;
import com.shoppingbackend.models.OrderStatus;
import com.shoppingbackend.repositories.IOrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStatusService implements IOrderStatusService{
    @Autowired
    private IOrderStatusRepository orderStatusRepository;

    @Override
    public Iterable<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public Optional<OrderStatus> findById(Long id) {
        return orderStatusRepository.findById(id);
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus update(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void delete(Long id) {
        orderStatusRepository.deleteById(id);
    }
}
