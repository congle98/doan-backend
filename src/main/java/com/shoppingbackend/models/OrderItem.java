package com.shoppingbackend.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private BigDecimal unitPrice;

    private int quantity;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
