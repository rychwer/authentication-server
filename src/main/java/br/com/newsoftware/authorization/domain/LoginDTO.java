package br.com.newsoftware.authorization.domain;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class LoginDTO {

    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "{email.invalid}")
    private String email;

    private String password;

}
