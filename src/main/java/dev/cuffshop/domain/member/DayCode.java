package dev.cuffshop.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DayCode {

    private String code;
    private String displayName;

    public DayCode(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
}
