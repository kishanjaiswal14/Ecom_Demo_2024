package com.kishan.ecom_demo.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int id;
    private String tittle;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
}
