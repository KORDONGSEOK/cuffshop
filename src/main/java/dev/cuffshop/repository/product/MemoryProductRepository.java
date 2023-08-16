package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemoryProductRepository implements ProductRepository {

    private static final Map<Long, Product> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Product save(Product product) {
        product.setId(++sequence);
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long productId, Product updateParam) {
        Product findProduct = findById(productId);
        findProduct.setProductName(updateParam.getProductName());
        findProduct.setCategoryType(updateParam.getCategoryType());
        findProduct.setPrice(updateParam.getPrice());
        findProduct.setDiscountRate(updateParam.getDiscountRate());
        findProduct.setQuantity(updateParam.getQuantity());
        findProduct.setDeliveryInfo(updateParam.getDeliveryInfo());
        findProduct.setProductInfo(updateParam.getProductInfo());
        findProduct.setDiscountPrice(updateParam.getDiscountPrice());
    }

    @Override
    public void delete(Long productId) {
        Product findProduct = findById(productId);
        store.remove(findProduct);
    }

    public void clearStore() {
        store.clear();
    }
}
