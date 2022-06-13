package com.example.modelsisspringbootfullstack.dto;

import com.example.modelsisspringbootfullstack.entities.Product;

import java.util.Collection;

public class ProductTypeDto {
    private Long id;
    private String name;
    private Collection<Product> products;
}
