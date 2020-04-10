package br.com.newsoftware.authorization.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="authority", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}, name="AUTHORITY_UNIQUE_NAME"))
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private Integer id;

    @Column(length=20)
    private String name;

}
