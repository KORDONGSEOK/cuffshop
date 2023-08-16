package dev.cuffshop.web.product;

import dev.cuffshop.domain.product.CategoryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class ProductSaveForm {

    @NotBlank
    private String productName;

    @NotNull
    private CategoryType categoryType;

    @NotNull
    @Min(1)
    private Integer price;

    @Range(min = 1, max = 99)
    private Integer discountRate;

    @NotNull
    @Max(9999)
    private Integer quantity;

    @NotBlank
    private String deliveryInfo;

    @NotBlank
    private String productInfo;

    private Integer discountPrice;

}
