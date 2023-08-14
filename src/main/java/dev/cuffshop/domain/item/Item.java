package dev.cuffshop.domain.item;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class Item {
    private Long id;

    private String itemName;    //상품명

    private Integer price;      // 가격


    private Integer quantity;    //재고수량

    private Boolean open;          //판매여부
    private List<String> regions; //등록 지역
    private ItemType itemType;    //상품종류
    private String deliveryCode; //배송방식

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
