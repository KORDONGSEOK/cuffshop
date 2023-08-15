package dev.cuffshop.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class Member {

    private Long id;

    private String email;

    private String password;

    private String year;
    private String monthCode;
    private String dayCode;
    private String phoneNumber;
    private Grade grade ;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member(String email, String password, String year, String monthCode, String dayCode, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.year = year;
        this.monthCode = monthCode;
        this.dayCode = dayCode;
        this.phoneNumber = phoneNumber;
    }
}
