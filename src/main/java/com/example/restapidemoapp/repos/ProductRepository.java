package com.example.restapidemoapp.repos;

import com.example.restapidemoapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
