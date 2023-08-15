package dev.cuffshop.test.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BasicLoginForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
