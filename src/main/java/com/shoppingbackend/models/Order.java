package com.shoppingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalQuantity;

    private String orderTrackingNumber;

    private BigDecimal totalPrice;

    @ManyToOne
    private OrderStatus status;

    private String addressDetail;

    @ManyToOne
    private City city;

    private String customerName;

    private String customerEmail;

    private String customerPhone;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;


    public void add(OrderItem item) {
        if(item != null){
            if(orderItems == null){
                orderItems = new ArrayList<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
