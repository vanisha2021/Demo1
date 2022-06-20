package com.eample.restapidemoapp.repos;

import com.eample.restapidemoapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
