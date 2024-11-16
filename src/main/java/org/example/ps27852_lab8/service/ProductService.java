package org.example.ps27852_lab8.service;

import org.example.ps27852_lab8.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    List<Product> findByCategoryId(Integer cid);
    Product saveProduct(Product product);
    Product updateProduct(Product product, Integer id);
    void deleteProduct(Integer id);
}
