package com.example.modelsisspringbootfullstack.web;

import com.example.modelsisspringbootfullstack.dao.ProductRepository;
import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.dto.ProductDto;
import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.Response;
import com.example.modelsisspringbootfullstack.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    List<Product> allTypeProduct() {
        logger.info("inside ProductRepository.allTypeProduct() method");
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public Response addProduct(@RequestBody ProductDto product){
        Response response=new Response();
         if(productRepository.findByName(product.getName())==null){
            try {
                logger.info("Adding Product " + product);
                productService.addproduit(product);
                response.setStatut(200);
                response.setDescription("Ajout réussie");
            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }
        else{
            response.setStatut(500);
            response.setDescription("Le Produit existe deja");
        }
        return response;
    }
    @PutMapping(value = "/products/{id}")
    public Response updateProduct(@PathVariable Long id, @RequestBody ProductDto product){
        Response response =new Response();
        Product prod=productRepository.findById(id).get();
        if(prod !=null ){
            try {
                logger.info("Updating TypeProduct " + product);
                productService.UpdateProduct(product,id);
                response.setStatut(200);
                response.setDescription("Modification reussi");

            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }else {
            response.setStatut(500);
            response.setDescription("Le Produit existe deja");
        }
        return response;
    }
}
