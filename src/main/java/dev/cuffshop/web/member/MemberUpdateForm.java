package dev.cuffshop.web.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class MemberUpdateForm {
    @NotNull
    private Long id;
    @NotNull
    private String email;
    @NotEmpty
    private String password;
}
