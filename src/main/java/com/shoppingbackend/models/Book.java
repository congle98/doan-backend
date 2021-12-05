package com.shoppingbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 3000)
    private String description;

    private BigDecimal price;

    private BigDecimal unitPrice;

    private BigDecimal salePrice = BigDecimal.valueOf(0);

    private boolean active = true;

    private int sold;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    private Author author;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItem>orderItem = new ArrayList<>();

}
