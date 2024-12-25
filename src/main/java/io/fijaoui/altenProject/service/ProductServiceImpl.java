package io.fijaoui.altenProject.service;

import io.fijaoui.altenProject.dto.ProductDto;
import io.fijaoui.altenProject.entities.Product;
import io.fijaoui.altenProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(ProductDto product) {
        return productRepository.save(product.toEntity());
    }

    @Override
    public Product updateProduct(Long id, ProductDto product) {
        return productRepository.save(product.toEntity());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
