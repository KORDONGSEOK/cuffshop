package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository {

    private static final Map<Long, Product> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Product save(Product goods) {
        goods.setId(++sequence);
        store.put(goods.getId(), goods);
        return goods;
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
    public void update(Long goodsId, Product updateParam) {
        Product findGoods = findById(goodsId);
        findGoods.setProductName(updateParam.getProductName());
        findGoods.setCategoryType(updateParam.getCategoryType());
        findGoods.setPrice(updateParam.getPrice());
        findGoods.setDiscountRate(updateParam.getDiscountRate());
        findGoods.setQuantity(updateParam.getQuantity());
        findGoods.setDeliveryInfo(updateParam.getDeliveryInfo());
        findGoods.setProductInfo(updateParam.getProductInfo());
    }

    public void clearStore() {
        store.clear();
    }
}
