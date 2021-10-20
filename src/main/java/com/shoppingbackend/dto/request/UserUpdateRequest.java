package com.shoppingbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    private Long id;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private String avatar;
}
