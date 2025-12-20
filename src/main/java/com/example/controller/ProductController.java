package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Product;
import com.example.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "商品管理", description = "商品相关接口")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "获取所有商品")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.list();
    }

    @Operation(summary = "分页获取商品")
    @GetMapping("/page")
    public Page<Product> getProductPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Product> page = new Page<>(pageNum, pageSize);
        return productService.page(page);
    }

    @Operation(summary = "根据ID获取商品")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "添加商品")
    @PostMapping
    public boolean addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @Operation(summary = "更新商品")
    @PutMapping
    public boolean updateProduct(@RequestBody Product product) {
        return productService.updateById(product);
    }

    @Operation(summary = "删除商品")
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.removeById(id);
    }

    @Operation(summary = "按分类搜索商品")
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", category);
        return productService.list(queryWrapper);
    }
}