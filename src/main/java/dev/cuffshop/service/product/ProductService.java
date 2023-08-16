package dev.cuffshop.service.product;

import dev.cuffshop.domain.product.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void update(Long productId, Product updateParam);

    void delete(Long productId);
}
