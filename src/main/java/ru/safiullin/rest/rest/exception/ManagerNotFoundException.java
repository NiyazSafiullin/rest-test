package ru.safiullin.rest.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Manager Not Found")
public class ManagerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ManagerNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
