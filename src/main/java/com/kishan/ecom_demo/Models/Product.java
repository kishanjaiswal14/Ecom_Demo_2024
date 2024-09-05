package com.kishan.ecom_demo.Models;

import com.kishan.ecom_demo.DTOs.ProductResponseDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String tittle;
    private double price;
    private String description;
    private String image;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    public ProductResponseDTO convertToDto(){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(super.getId());
        productResponseDTO.setTittle(tittle);
        productResponseDTO.setPrice(price);
        productResponseDTO.setDescription(description);
        productResponseDTO.setDescription(image);
        return productResponseDTO;
    }
}
