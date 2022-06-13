package com.example.modelsisspringbootfullstack.web;
import com.example.modelsisspringbootfullstack.dao.ProductTypeRepository;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import com.example.modelsisspringbootfullstack.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.modelsisspringbootfullstack.entities.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class ProductTypeController {
    private static final Logger logger = LoggerFactory.getLogger(ProductTypeController.class);
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/productType")
    List<ProductType> allTypeProduct() {
        logger.info("inside TypeProductController.allTypeProduct() method");
        return productTypeRepository.findAll();
    }

    @PostMapping("/productType")
    public Response newTypeProduct(@RequestBody ProductType typeProduct){
        Response response=new Response();
        if(productTypeRepository.findByName(typeProduct.getName())==null){
            try {
                logger.info("Adding TypeProduct " + typeProduct);
                productTypeService.addTypeproduit(typeProduct);
                response.setStatut(200);
                response.setDescription("Ajout réussie");
            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }
        else{
            response.setStatut(500);
            response.setDescription("Le Type Produit existe deja");
        }
        return response;
    }
}
