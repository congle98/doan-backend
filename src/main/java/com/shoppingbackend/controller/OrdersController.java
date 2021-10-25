package com.shoppingbackend.controller;

import com.shoppingbackend.models.Order;
import com.shoppingbackend.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public ResponseEntity<Iterable<Order>> finAllOrder(@RequestParam Long id ){
        Iterable<Order> ordersPage = null;
        if(id != 0){
            ordersPage = orderService.getAllByCustomer(id);
        }
        return new ResponseEntity<>(ordersPage, HttpStatus.OK);
    }
    @PutMapping("/change-status/{orderId}")
    public ResponseEntity<Order> changeOrderStatus(@RequestBody Long statusId,@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.changeOrderStatus(orderId,statusId),HttpStatus.OK);
    }


}
