package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.dto.ProductDto;
import com.example.modelsisspringbootfullstack.entities.Product;

public interface ProductService {
    Product addproduit(ProductDto product);
    Product UpdateProduct(ProductDto product, Long id);
}
