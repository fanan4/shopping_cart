package com.shopping_cart.shopping_cart.service.product;

import com.shopping_cart.shopping_cart.exception.productExceptions.ProductNotFoundException;
import com.shopping_cart.shopping_cart.model.Category;
import com.shopping_cart.shopping_cart.model.Product;
import com.shopping_cart.shopping_cart.repository.CategoryRepository;
import com.shopping_cart.shopping_cart.repository.ProductRepository;
import com.shopping_cart.shopping_cart.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product not found!"));
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        // check if category exist or Not
        // if Yes set it as product category
        // if not save the new category
        // set is as the product category

        Category category= Optional.ofNullable(categoryRepository.findByName(productRequest.getCategory().getName()))
                .orElseGet(()->{
                    Category newCategory=new Category(productRequest.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        productRequest.setCategory(category);
        return  createProduct(productRequest,category);
    }
    public  Product createProduct(ProductRequest productRequest, Category category) {
        return new Product(
         productRequest.getName(),
         productRequest.getDescription(),
         productRequest.getBrand(),
         productRequest.getPrice(),
         productRequest.getInventory(),
         category
        );
    }
    @Override
    public void deleteProductById(long id) {
        // deletion
        // check first if the product does exist
        // to delete
        // if the product does not exsit throw an exception

          productRepository.findById(id).ifPresentOrElse(productRepository::delete,
               ()-> {throw new ProductNotFoundException("product not found");}
       );
    }

    @Override
    public void updateProductById(Product product, long id) {

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brand) {
        return productRepository.findByCategoryNameAndBrand(categoryName,brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand,name);
    }

    @Override
    public long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand,name);
    }

}
