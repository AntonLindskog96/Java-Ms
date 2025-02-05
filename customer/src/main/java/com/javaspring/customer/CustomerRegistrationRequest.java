package com.javaspring.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email

) {
}
