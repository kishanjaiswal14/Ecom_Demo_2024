package com.kishan.ecom_demo.Services;

import com.kishan.ecom_demo.DTOs.ProductResponseDTO;
import com.kishan.ecom_demo.Exceptions.NotFoundException;
import com.kishan.ecom_demo.Models.Product;

public interface ProductService {
    public Product getSingleProduct(int id) throws NotFoundException;
}
