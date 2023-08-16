package dev.cuffshop.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class Product {
    private Long id;

    private String productName;

    private CategoryType categoryType;

    @NumberFormat(pattern = "###,###원")
    private Integer price;

    private Integer discountRate;

    @NumberFormat(pattern = "###,###")
    private Integer quantity;

    private String deliveryInfo;

    private String productInfo;
    @NumberFormat(pattern = "###,###원")
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

    public Product(String productName, Integer price, Integer discountRate, Integer quantity, String deliveryInfo, String productInfo, Integer discountPrice) {
        this.productName = productName;
        this.price = price;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.deliveryInfo = deliveryInfo;
        this.productInfo = productInfo;
        this.discountPrice = discountPrice;
    }

    public Product(String productName, CategoryType categoryType, Integer price, Integer discountRate, Integer quantity, String deliveryInfo, String productInfo, Integer discountPrice) {
        this.productName = productName;
        this.categoryType = categoryType;
        this.price = price;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.deliveryInfo = deliveryInfo;
        this.productInfo = productInfo;
        this.discountPrice = discountPrice;
    }
}
