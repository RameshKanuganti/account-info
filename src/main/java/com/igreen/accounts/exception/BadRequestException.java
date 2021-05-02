package com.igreen.accounts.exception;

import com.igreen.accounts.util.AccountResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BadRequestException extends Exception {

    private static final long serialVersionUID = -4744430183523721711L;

    private String message = "";

    private AccountResponse accountResponse;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public BadRequestException(AccountResponse response) {
        this.accountResponse = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

}