package com.shoppingbackend.models;

import javax.persistence.*;

@Entity
@Table
public class City  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
