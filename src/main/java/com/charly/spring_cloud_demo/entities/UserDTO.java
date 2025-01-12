package com.charly.spring_cloud_demo.entities;

public record UserDTO(
        String firstName,
        String lastName,
        int age,
        String email
) {
}
