package br.com.newsoftware.authorization.controller.handle;

import br.com.newsoftware.authorization.controller.exception.UserExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error(ex.getLocalizedMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserExistsException.class)
    @ResponseBody
    public Map<String, Object> handleValidationExceptions(UserExistsException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        errors.put("statusMessage", HttpStatus.BAD_REQUEST.value());
        log.error(ex.getLocalizedMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleGenerateExceptions(Exception ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("status code", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        errors.put("message", "Internal Server Error");
        log.error(ex.getLocalizedMessage());
        return errors;
    }

}
