package com.afriquecode;

import com.afriquecode.entities.AppRole;
import com.afriquecode.service.AccountService;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogUserApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.save(new AppRole(null, "USER"));
            accountService.save(new AppRole(null, "ADMIN"));
            Stream.of("user1", "user2", "user3", "admin").forEach(usr -> {
                accountService.saveUser(usr, "1234", "1234");
            });
            accountService.addRoleToUser("admin", "ADMIN");
        };
    }

}
