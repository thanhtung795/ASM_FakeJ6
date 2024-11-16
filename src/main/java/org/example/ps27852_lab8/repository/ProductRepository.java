package org.example.ps27852_lab8.repository;

import org.example.ps27852_lab8.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Integer id);
}
