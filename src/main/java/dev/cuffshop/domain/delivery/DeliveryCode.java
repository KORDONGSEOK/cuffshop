package dev.cuffshop.domain.delivery;

import lombok.Getter;
import lombok.Setter;

/**
 * FAST : 빠른 배송
 * NORMAL : 일반 배송
 * SLOW : 느린 배송
 */
@Getter @Setter
public class DeliveryCode {
    private String code;
    private String displayName;

    public DeliveryCode(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
}
