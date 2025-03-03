package com.javaspring.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
        System.out.println("hello world");

        //http://localhost:5050/browser/
        //localhost:8080/api/v1/customers insomnia

    }
}
