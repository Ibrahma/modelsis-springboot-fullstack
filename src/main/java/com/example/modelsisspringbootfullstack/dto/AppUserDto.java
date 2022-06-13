package com.example.modelsisspringbootfullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUserDto {
    private String username;
    private String password;
    private String confirmedPassword;

}
