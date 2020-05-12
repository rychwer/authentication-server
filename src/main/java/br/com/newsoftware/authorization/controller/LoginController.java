package br.com.newsoftware.authorization.controller;

import br.com.newsoftware.authorization.domain.LoginDTO;
import br.com.newsoftware.authorization.facade.LoginFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginFacade loginFacade;

    public LoginController(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    @PostMapping("/client")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createClientLogin(@RequestBody @Valid LoginDTO loginDTO) {
        loginFacade.createClientLogin(loginDTO);
    }

    @PostMapping("/professional")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfessionalLogin(@RequestBody @Valid LoginDTO loginDTO) {
        loginFacade.createProfessionalLogin(loginDTO);
    }

}
