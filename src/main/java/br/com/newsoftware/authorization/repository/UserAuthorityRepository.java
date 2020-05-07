package br.com.newsoftware.authorization.repository;

import br.com.newsoftware.authorization.domain.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {

    @Query("SELECT DISTINCT ua FROM UserAuthority ua WHERE ua.authority.name = :authorityName")
    Set<UserAuthority> findByAuthority(@Param("authorityName") String authorityName);

}
