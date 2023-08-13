package dev.cuffshop.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class Product {
    private Long id;

    private String productName;

    private CategoryType categoryType;

    private Integer price;
    private Integer discountRate;

    private Integer quantity;

    private String deliveryInfo;

    private String productInfo;
    private Integer discountPrice;

    public Product() {
    }

    public Product(String productName, Integer price, Integer discountRate, Integer quantity, String deliveryInfo, String productInfo) {
        this.productName = productName;
        this.price = price;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.deliveryInfo = deliveryInfo;
        this.productInfo = productInfo;
    }
}
