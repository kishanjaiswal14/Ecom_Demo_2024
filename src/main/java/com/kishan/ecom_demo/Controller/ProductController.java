package com.kishan.ecom_demo.Controller;

import com.kishan.ecom_demo.DTOs.ProductResponseDTO;
import com.kishan.ecom_demo.Exceptions.NotFoundException;
import com.kishan.ecom_demo.Models.Product;
import com.kishan.ecom_demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getByID(@PathVariable("id") int id)
                                    throws NotFoundException {
        Product product = productService.getSingleProduct(id);
        //return product.convertToDTO();
        return new ResponseEntity<>(product.convertToDto(), HttpStatus.OK);
    }
}
