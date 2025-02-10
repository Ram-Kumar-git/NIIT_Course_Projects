package com.bej.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason="User already exists")// a response when a specific exception is thrown or a method is invoked
public class UserAlreadyExistsException extends Exception {
}
