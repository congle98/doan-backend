package com.shoppingbackend.dto.request;

import com.shoppingbackend.models.Order;
import com.shoppingbackend.models.OrderItem;
import com.shoppingbackend.models.User;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private User customer;

    private Order order;

    private Set<OrderItem> orderItems;
}
