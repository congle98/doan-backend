package com.shoppingbackend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressDetail;

    private String city;

    @OneToOne
    private Order order;


}
