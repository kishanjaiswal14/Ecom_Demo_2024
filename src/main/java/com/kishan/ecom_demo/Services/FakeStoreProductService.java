package com.kishan.ecom_demo.Services;

import com.kishan.ecom_demo.DTOs.FakeStoreProductDTO;
import com.kishan.ecom_demo.Exceptions.NotFoundException;
import com.kishan.ecom_demo.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(int id) throws NotFoundException {
        FakeStoreProductDTO fakeStoreDTO = restTemplate.getForObject(
          "http://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class
        );

        if(fakeStoreDTO == null){
            throw new NotFoundException("Product with id : " + id + " not found"
                     + "please provide id < 21");
        }

        return fakeStoreDTO.toProduct();
    }
}
