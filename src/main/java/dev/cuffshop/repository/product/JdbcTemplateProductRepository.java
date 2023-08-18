package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class JdbcTemplateProductRepository implements ProductRepository{

    private final JdbcTemplate template;

    public JdbcTemplateProductRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Product save(Product product) {
        String sql = "insert into product ";
        sql += "(product_name, category_type, price, discount_rate, discount_price, quantity, delivery_info, product_info ";
        sql += "values (?, ?, ?, ?, ?, ?, ?, ? )";



        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void update(Long productId, Product updateParam) {

    }

    @Override
    public void delete(Long productId) {

    }
}
