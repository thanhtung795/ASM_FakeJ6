package org.example.ps27852_lab8.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Category;
import org.example.ps27852_lab8.service.CategorySetvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/categories")
@RequiredArgsConstructor
public class RestCategory {
    private final CategorySetvice categorySetvice;
    @GetMapping
    public List<Category> listCategories() {
        return categorySetvice.getAllCategories();
    }
}
