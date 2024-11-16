package org.example.ps27852_lab8.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Product;
import org.example.ps27852_lab8.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public String listProducts(Model model,  @RequestParam("cid") Optional<Integer> cid) {
        if(cid.isPresent()){
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("products",list);
        }else {
            List<Product> list = productService.getAllProducts();
            model.addAttribute("products",list);
        }
        return "product/list";
    }
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/detail";
    }
}
