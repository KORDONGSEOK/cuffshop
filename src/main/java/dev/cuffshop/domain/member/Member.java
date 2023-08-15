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

    private Grade grade ;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
