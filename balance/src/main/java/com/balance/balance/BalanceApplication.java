package com.balance.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BalanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalanceApplication.class, args);
    }

}
