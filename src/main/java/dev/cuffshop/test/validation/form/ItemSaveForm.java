package dev.cuffshop.test.validation.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class ItemSaveForm {

    @NotBlank
    private String itemName;    //상품명
    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;      // 가격

    @NotNull
    @Max(9999)
    private Integer quantity;    //재고수량
}
