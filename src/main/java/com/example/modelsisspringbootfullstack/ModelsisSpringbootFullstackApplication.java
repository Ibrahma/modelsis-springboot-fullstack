package com.example.modelsisspringbootfullstack;

import com.example.modelsisspringbootfullstack.entities.AppRole;
import com.example.modelsisspringbootfullstack.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class ModelsisSpringbootFullstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelsisSpringbootFullstackApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args->{
            accountService.save(new AppRole(null,"USER"));
            accountService.save(new AppRole(null,"ADMIN"));

        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}
