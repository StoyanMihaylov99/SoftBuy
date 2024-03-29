package com.example.softwareecommers;

import com.example.softwareecommers.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SoftwareECommersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareECommersApplication.class, args);
    }

}
