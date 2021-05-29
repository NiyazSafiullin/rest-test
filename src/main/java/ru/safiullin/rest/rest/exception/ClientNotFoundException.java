package ru.safiullin.rest.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
public class ClientNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
