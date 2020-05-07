package br.com.newsoftware.authorization.facade;

import br.com.newsoftware.authorization.controller.exception.UserExistsException;
import br.com.newsoftware.authorization.domain.LoginDTO;
import br.com.newsoftware.authorization.domain.enums.AuthorityEnum;
import br.com.newsoftware.authorization.service.LoginService;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

    private LoginService loginService;

    public LoginFacade(LoginService loginService) {
        this.loginService = loginService;
    }

    private void createLogin(LoginDTO loginDTO, AuthorityEnum authorityEnum) {

        if(loginService.loginExists(loginDTO)) {
            throw new UserExistsException("User already in database");
        }

        loginService.createUser(loginDTO, authorityEnum);
    }

    public void createClientLogin(LoginDTO loginDTO) {
        createLogin(loginDTO, AuthorityEnum.ADMIN);
    }

    public void createProfessionalLogin(LoginDTO loginDTO) {
        createLogin(loginDTO, AuthorityEnum.ADMIN);
    }

}
