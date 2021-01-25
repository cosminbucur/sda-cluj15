package com.sda.spring.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    // runs after application start
    @Override
    public void run(String... args) {
        // create 2 products
        Product car = new Product("car", 5000);
        Product tv = new Product("tv", 400);

        productRepository.save(car);
        productRepository.save(tv);
    }
}
