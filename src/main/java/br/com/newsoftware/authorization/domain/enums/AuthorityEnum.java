package br.com.newsoftware.authorization.domain.enums;

public enum AuthorityEnum {

    CLIENT("CLIENT"),PROFESSIONAL("PROFESSIONAL"),ADMIN("ADMIN");

    private String authorityName;

    AuthorityEnum(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityName() {
        return this.authorityName;
    }


}
