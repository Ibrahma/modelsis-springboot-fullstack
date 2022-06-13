package com.example.modelsisspringbootfullstack;
import com.example.modelsisspringbootfullstack.dao.ProductRepository;
import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTypeTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Test
    void addTypeProduit() {
        ArrayList<Product> listProduct=new ArrayList<Product>();
        ProductType tProduct=new ProductType(1L,"type 1",listProduct);
        productTypeRepository.save(tProduct);
        Assertions.assertThat(tProduct.getId()).isGreaterThan(0);

    }
}
