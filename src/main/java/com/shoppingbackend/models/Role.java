package com.shoppingbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {
    }

    public Role(Long roleId, String roleName) {
        this.id = roleId;
        this.name = roleName;
    }

    public Long getRoleId() {
        return id;
    }

    public void setRoleId(Long roleId) {
        this.id = roleId;
    }

    public String getRoleName() {
        return name;
    }

    public void setRoleName(String roleName) {
        this.name = roleName;
    }
}

