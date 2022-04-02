package com.ecommerce.domain.repository.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
