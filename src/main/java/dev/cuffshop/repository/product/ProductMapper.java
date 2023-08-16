package dev.cuffshop.repository.product;

import dev.cuffshop.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    void save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void update(@Param("id") Long id, @Param("product") Product updateParam);

}
