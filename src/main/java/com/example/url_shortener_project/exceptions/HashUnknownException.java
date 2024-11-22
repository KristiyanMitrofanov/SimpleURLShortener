package com.example.url_shortener_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HashUnknownException extends RuntimeException{

    public HashUnknownException(String message) {
        super(message);
    }
}
