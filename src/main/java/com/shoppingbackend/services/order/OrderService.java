package com.shoppingbackend.services.order;
import com.shoppingbackend.models.Order;
import com.shoppingbackend.models.OrderStatus;
import com.shoppingbackend.repositories.IOrderRepository;
import com.shoppingbackend.services.orderStatus.IOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IOrderStatusService statusService;


    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Iterable<Order> getAllByCustomer(Long id) {
        return orderRepository.findAllByCustomerIdOrderByDateCreatedDesc(id);
    }

    @Override
    public Order changeOrderStatus(Long id, Long statusId) {
        OrderStatus orderStatus = statusService.findById(statusId).get();
        Order order = orderRepository.findById(id).get();
        order.setStatus(orderStatus);
       return orderRepository.save(order);
    }
}
