package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.dto.ProductTypeDto;
import com.example.modelsisspringbootfullstack.entities.ProductType;

public interface ProductTypeService {
    ProductType addTypeproduit(ProductType typeProduct);
    ProductType UpdateTypeProduct(ProductType typeProduct, Long id);
}
