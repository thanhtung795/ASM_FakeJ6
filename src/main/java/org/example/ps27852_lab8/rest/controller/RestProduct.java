package org.example.ps27852_lab8.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.controller.ProductController;
import org.example.ps27852_lab8.entity.Product;
import org.example.ps27852_lab8.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
@RequiredArgsConstructor
public class RestProduct {
    private final ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product detailProduct(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    }
}
