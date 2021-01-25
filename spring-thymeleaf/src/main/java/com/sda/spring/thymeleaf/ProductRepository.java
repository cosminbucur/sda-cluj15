package com.sda.spring.thymeleaf;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// var 1: jpa implementation: entity manager
// var 2: hibernate implementation: session
// var 3: spring data implementation: extend Repository
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();
}
