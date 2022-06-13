package com.example.modelsisspringbootfullstack.dao;

import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByName(String name);
    public ProductType findByProductType(Long id);
}
