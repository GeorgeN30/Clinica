package com.Gns.clinica.security.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String access_token;
    private String refresh_token;
    private String role;
    private String email;
}
