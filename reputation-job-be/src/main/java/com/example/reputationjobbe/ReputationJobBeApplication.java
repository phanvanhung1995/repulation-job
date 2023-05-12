package com.example.reputationjobbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class ReputationJobBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReputationJobBeApplication.class, args);
        String a = "111111";
        String b = BCrypt.hashpw(a, BCrypt.gensalt(12));
        System.out.println(b);
    }
}
