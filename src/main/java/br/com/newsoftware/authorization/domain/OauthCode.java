package br.com.newsoftware.authorization.domain;

import javax.persistence.*;

@Entity
@Table(name="oauth_code")
public class OauthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Column(name="code")
    private String code;

    @Lob
    @Column(name="authentication", columnDefinition = "mediumblob")
    private byte[] authentication;

}
