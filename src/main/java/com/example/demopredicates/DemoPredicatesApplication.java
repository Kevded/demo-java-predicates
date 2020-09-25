package com.example.demopredicates;

import com.example.demopredicates.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoPredicatesApplication implements CommandLineRunner {
    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(DemoPredicatesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
