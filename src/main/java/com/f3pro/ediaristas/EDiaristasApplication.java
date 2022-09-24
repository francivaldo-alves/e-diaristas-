package com.f3pro.ediaristas;

import com.f3pro.ediaristas.config.PasswordEnconderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class EDiaristasApplication {
    
    @Autowired


    public static void main(String[] args) {
        SpringApplication.run(EDiaristasApplication.class, args);
     //   String encoded = new BCryptPasswordEncoder().encode("123");
       // System.out.println(encoded);
    }


}
