package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void update(Long productId, Product updateParam);

    void delete(Long productId);
}
