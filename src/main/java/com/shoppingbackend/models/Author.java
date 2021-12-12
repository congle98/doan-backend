package com.shoppingbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Author(Long id, String name, boolean active, String introduce) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.introduce = introduce;
    }

    private String name;

    private boolean active = true;

    @Column(length = 1000)
    private String introduce;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();
}
