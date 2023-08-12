package dev.cuffshop.domain.product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private Long id;
    private String goodsName;
    private CategoryType category;
    private Integer price;
    private Integer discountRate;
    private Integer quantity;
    private String deliveryInfo;
    private String goodsInfo;

    public Product() {
    }

    public Product(String goodsName, Integer price, Integer discountRate, Integer quantity, String deliveryInfo, String goodsInfo) {
        this.goodsName = goodsName;
        this.price = price;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.deliveryInfo = deliveryInfo;
        this.goodsInfo = goodsInfo;
    }
}
