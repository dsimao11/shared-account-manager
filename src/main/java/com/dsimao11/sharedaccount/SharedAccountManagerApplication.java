package com.dsimao11.sharedaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.dsimao11.sharedaccount.repositories")
public class SharedAccountManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedAccountManagerApplication.class, args);
    }

}
