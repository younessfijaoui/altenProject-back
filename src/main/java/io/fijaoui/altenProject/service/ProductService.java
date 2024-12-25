package io.fijaoui.altenProject.service;

import io.fijaoui.altenProject.dto.ProductDto;
import io.fijaoui.altenProject.entities.Product;
import io.fijaoui.altenProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Page<Product> getProducts(Pageable pageable);

    Product getProduct(Long id);

    Product createProduct(ProductDto product);

    Product updateProduct(Long id, ProductDto product);

    void deleteProduct(Long id);
}
