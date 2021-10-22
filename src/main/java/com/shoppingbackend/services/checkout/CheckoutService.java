package com.shoppingbackend.services.checkout;

import com.shoppingbackend.dto.request.Purchase;
import com.shoppingbackend.dto.response.PurchaseResponse;
import com.shoppingbackend.models.*;
import com.shoppingbackend.services.book.IBookService;
import com.shoppingbackend.services.order.IOrderService;
import com.shoppingbackend.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutService implements ICheckoutService{
    @Autowired
    private IUserService userService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(1L);
        order.setStatus(orderStatus);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            Book book = bookService.findById( orderItem.getBook().getId()).get();
            book.setSold(book.getSold()+orderItem.getQuantity());
            bookService.save(book);
            order.add(orderItem);
        }
        User customer = purchase.getCustomer();
        Optional<User> customerFormDB = userService.findByEmail(customer.getEmail());
        if(customerFormDB.isPresent()){
            customer = customerFormDB.get();
            customer.add(order);
            userService.save(customer);
        }
        else {
            orderService.save(order);
        }
        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
