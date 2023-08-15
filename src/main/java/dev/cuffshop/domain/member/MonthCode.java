package dev.cuffshop.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MonthCode {

    private String code;
    private String displayName;

    public MonthCode(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
}

