package br.com.newsoftware.authorization.service;

import br.com.newsoftware.authorization.domain.Authority;
import br.com.newsoftware.authorization.domain.LoginDTO;
import br.com.newsoftware.authorization.domain.User;
import br.com.newsoftware.authorization.domain.UserAuthority;
import br.com.newsoftware.authorization.domain.enums.AuthorityEnum;
import br.com.newsoftware.authorization.repository.AuthorityRepository;
import br.com.newsoftware.authorization.repository.UserAuthorityRepository;
import br.com.newsoftware.authorization.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LoginService {

    private UserRepository userRepository;

    private UserAuthorityRepository userAuthorityRepository;

    private AuthorityRepository authorityRepository;

    private PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, UserAuthorityRepository userAuthorityRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userAuthorityRepository = userAuthorityRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean loginExists(LoginDTO loginDTO) {
        final User user = this.userRepository.findByUsername(loginDTO.getEmail());

        if(user != null) {
            return true;
        }

        return false;
    }

    public void createUser(LoginDTO loginDTO, AuthorityEnum authorityEnum) {

        final Authority autority = this.authorityRepository.findByName(authorityEnum.getAuthorityName());

        User user = new User();
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setCredentialsExpired(false);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        user.setUserName(loginDTO.getEmail());

        userRepository.save(user);

        final UserAuthority userAuthority = new UserAuthority();
        userAuthority.setAuthority(autority);
        userAuthority.setUser(user);

        this.userAuthorityRepository.save(userAuthority);
    }

}
