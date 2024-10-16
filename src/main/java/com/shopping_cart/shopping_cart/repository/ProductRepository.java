package com.shopping_cart.shopping_cart.repository;

import com.shopping_cart.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    List<Product> findByCategoryName(String categoryName);

    List<Product> findByCategoryNameAndBrand(String categoryName, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String brand, String name);

    long countByBrandAndName(String brand, String name);
}
