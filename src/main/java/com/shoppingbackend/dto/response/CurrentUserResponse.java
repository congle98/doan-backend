package com.shoppingbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserResponse {
    private Long id;
    private String role;
    private String fullName;
    private String avatar;
}
