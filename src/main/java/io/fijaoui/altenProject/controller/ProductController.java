package io.fijaoui.altenProject.controller;

import io.fijaoui.altenProject.dto.ProductDto;
import io.fijaoui.altenProject.entities.Product;
import io.fijaoui.altenProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto product) {
        return productService.createProduct(product);
    }

    @PatchMapping
    public Product updateProduct(@RequestBody ProductDto product) {
        return productService.updateProduct(product.id(), product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody ProductDto product) {
        productService.deleteProduct(product.id());
    }
}
