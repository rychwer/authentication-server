package br.com.newsoftware.authorization.controller.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String message) {
        super(message);
    }

}
