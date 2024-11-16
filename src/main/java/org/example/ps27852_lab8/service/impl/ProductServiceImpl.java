package org.example.ps27852_lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Product;
import org.example.ps27852_lab8.repository.ProductRepository;
import org.example.ps27852_lab8.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByCategoryId(Integer cid) {
        return productRepository.findByCategoryId(cid);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        Product p = productRepository.findById(id).orElse(null);
        if (p != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
