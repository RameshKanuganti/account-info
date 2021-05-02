package com.igreen.accounts.exception;

import com.igreen.accounts.util.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected AccountResponse handleNoHandlerFoundException() {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.NOT_FOUND.value());
        accountResponse.setError("Invalid resource path");
        accountResponse.setMessage("url not found");
        return accountResponse;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    AccountResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                           final HttpServletRequest request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.NOT_FOUND.value());
        accountResponse.setError(HttpStatus.NOT_FOUND.name());
        accountResponse.setMessage(exception.getMessage());
        return accountResponse;
    }

    @ExceptionHandler({APIException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    AccountResponse handleException(final Exception exception, final HttpServletRequest request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        accountResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        accountResponse.setMessage(exception.getMessage());
        return accountResponse;
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    AccountResponse handleInvalidInputException(final BadRequestException exception,
                                                final HttpServletRequest request) {
        return exception.getAccountResponse();

    }
}