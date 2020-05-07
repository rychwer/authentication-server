package br.com.newsoftware.authorization.controller;

import br.com.newsoftware.authorization.domain.LoginDTO;
import br.com.newsoftware.authorization.facade.LoginFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginFacade loginFacade;

    public LoginController(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    @PostMapping("/client")
    public void createClientLogin(@RequestBody @Valid LoginDTO loginDTO) {
        loginFacade.createClientLogin(loginDTO);
    }

    @PostMapping("/professional")
    public void createProfessionalLogin(@RequestBody @Valid LoginDTO loginDTO) {
        loginFacade.createProfessionalLogin(loginDTO);
    }

}
