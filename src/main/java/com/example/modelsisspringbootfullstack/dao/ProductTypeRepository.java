package com.example.modelsisspringbootfullstack.dao;

import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType,Long> {
    public ProductType findByName(String name);
}
