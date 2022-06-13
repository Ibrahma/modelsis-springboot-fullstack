package com.example.modelsisspringbootfullstack;
import com.example.modelsisspringbootfullstack.dao.ProductRepository;
import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Test
    void addproduit() {
        ProductType prodcutType = productTypeRepository.getById(1L);
        Product product = new Product(1l,"produit 10",new Date(),prodcutType);
        productRepository.save(product);
        Assertions.assertThat(product.getId()).isGreaterThan(0);

    }

    @Test
    public void updateProduct(){
        Product product = productRepository.findById(1L).get();
        product.setName("produit 10");
        Product productUpdated =  productRepository.save(product);
        Assertions.assertThat(product.getName()).isEqualTo("produit 10");
    }
}
