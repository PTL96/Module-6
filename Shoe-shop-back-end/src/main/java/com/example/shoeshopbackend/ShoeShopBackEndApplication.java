package com.example.shoeshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShoeShopBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoeShopBackEndApplication.class, args);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("147258"));
    }
    }


