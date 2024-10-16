package com.shopping_cart.shopping_cart.service.product;

import com.shopping_cart.shopping_cart.model.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(long id);

    Product addProduct(Product product);

    void deleteProductById(long id);

    void updateProductById(Product product,long id);

    List<Product> getAllProduct();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCategoryAndBrand(String category,String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand,String name);

    long countProductsByBrandAndName(String brand, String name);

}
