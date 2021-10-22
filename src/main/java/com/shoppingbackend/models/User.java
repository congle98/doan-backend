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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phone;

    private boolean status = true;

    private String avatarUrl;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    private Role role;

    public void add(Order order){
        if(order != null){
            if(orders == null){
                orders = new ArrayList<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }

}
