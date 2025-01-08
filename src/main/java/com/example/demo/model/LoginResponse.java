package com.example.demo.model;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private int code;
    private String message;
}