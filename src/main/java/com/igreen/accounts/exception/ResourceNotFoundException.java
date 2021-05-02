package com.igreen.accounts.exception;

import com.igreen.accounts.util.AccountResponse;

public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -9079454849611061074L;

    private AccountResponse accountResponse;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

}