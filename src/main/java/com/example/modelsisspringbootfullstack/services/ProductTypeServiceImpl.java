package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.dto.ProductTypeDto;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public ProductType addTypeproduit(ProductType typeProduct) {
        return productTypeRepository.saveAndFlush(typeProduct);
    }

    @Override
    public ProductType UpdateTypeProduct(ProductType typeProduct, Long id) {
        ProductType typePro =new ProductType();
        typePro.setName(typePro.getName());
        typePro.setId(id);
        return productTypeRepository.saveAndFlush(typePro);
    }
}
