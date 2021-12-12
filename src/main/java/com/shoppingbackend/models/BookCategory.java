package com.shoppingbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BookCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private String name;

    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "bookCategory")
    @JsonIgnore
    private List<Book> books;
}
