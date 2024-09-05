package com.kishan.ecom_demo.DTOs;

import com.kishan.ecom_demo.Models.Category;
import com.kishan.ecom_demo.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String tittle;
    private double price;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setTittle(this.tittle);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImage(this.image);

        Category category = new Category();
        category.setTittle(this.category);

        product.setCategory(category);

        return product;
    }
}
