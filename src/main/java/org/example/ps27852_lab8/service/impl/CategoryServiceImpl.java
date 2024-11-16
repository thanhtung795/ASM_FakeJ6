package org.example.ps27852_lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Category;
import org.example.ps27852_lab8.repository.CategoryRepository;
import org.example.ps27852_lab8.service.CategorySetvice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategorySetvice {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
