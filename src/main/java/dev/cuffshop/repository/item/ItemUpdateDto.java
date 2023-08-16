package dev.cuffshop.repository.item;

import dev.cuffshop.domain.item.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ItemUpdateDto {

    private String itemName;
    private Integer price;
    private Integer quantity;

    private Boolean open;          //판매여부
    private List<String> regions; //등록 지역
    private ItemType itemType;    //상품종류
    private String deliveryCode; //배송방식

    public ItemUpdateDto() {
    }

    public ItemUpdateDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
