package dev.cuffshop.web.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
}
