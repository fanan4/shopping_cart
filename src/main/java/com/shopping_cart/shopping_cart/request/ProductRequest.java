package com.shopping_cart.shopping_cart.request;

import com.shopping_cart.shopping_cart.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private String brand;
    private float price;
    private float inventory;
    private Category category;
}
