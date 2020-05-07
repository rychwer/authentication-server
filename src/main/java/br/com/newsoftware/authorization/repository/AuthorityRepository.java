package br.com.newsoftware.authorization.repository;

import br.com.newsoftware.authorization.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String nameAuthority);

}
