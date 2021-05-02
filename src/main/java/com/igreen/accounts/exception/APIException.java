package com.igreen.accounts.exception;

import com.igreen.accounts.util.AccountResponse;

public class APIException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private AccountResponse accountResponse;

    public APIException() {
        super();
    }

    public APIException(final String message) {
        super(message);
    }

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

}