package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MyBatisItemRepository implements ProductRepository{

    private final ProductMapper productMapper;

    @Autowired
    public MyBatisItemRepository(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        log.info("productMapper class={}", productMapper.getClass());
        productMapper.save(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void update(Long productId, Product updateParam) {
        productMapper.update(productId, updateParam);
    }

    @Override
    public void delete(Long productId) {

    }
}
