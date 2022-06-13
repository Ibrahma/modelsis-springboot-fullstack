package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.dao.ProductRepository;
import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.dto.ProductDto;
import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public Product addproduit(ProductDto product) {
        ProductType typeProduct=productTypeRepository.findByName(product.getType());
        Product p=new Product();
        p.setName(product.getName());
        p.setDate(new Date());
        p.setProductType(typeProduct);
        return productRepository.saveAndFlush(p);
    }

    @Override
    public Product UpdateProduct(ProductDto product, Long id) {
        Product prod=productRepository.findById(id).get();
        ProductType productType=productTypeRepository.findByName(product.getType());
        prod.setName(product.getName());
        prod.setDate(new Date());
        prod.setProductType(productType);
        return productRepository.saveAndFlush(prod);
    }
}