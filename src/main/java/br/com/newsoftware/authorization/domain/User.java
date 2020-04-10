package br.com.newsoftware.authorization.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = {"userName"}, name="USER_UNIQUE_USERNAME"))
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Column(length=50)
    private String userName;

    @Column
    private String password;

    @Column
    private Boolean accountExpired;

    @Column
    private Boolean accountLocked;

    @Column
    private Boolean credentialsExpired;

    @Column
    private Boolean enabled;

    @OneToMany(mappedBy = "user", targetEntity = UserAuthority.class, cascade = {
            CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

}
