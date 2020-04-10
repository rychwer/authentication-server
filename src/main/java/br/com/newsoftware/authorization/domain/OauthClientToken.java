package br.com.newsoftware.authorization.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="oauth_client_token")
@Getter
@Setter
public class OauthClientToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Column(name="token_id")
    private String tokenId;

    @Lob
    @Column(name="token", columnDefinition = "mediumblob")
    private byte[] token;

    @Column(name="authentication_id")
    private String authenticationId;

    @Column(name="user_name")
    private String userName;

    @Column(name="client_id")
    private String clientId;

}
