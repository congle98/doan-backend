package com.shoppingbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordRequest {
    private Long id;
    private String oldPassword;
    private String newPassword;
}
