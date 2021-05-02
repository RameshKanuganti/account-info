package com.igreen.accounts.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AccountResponse {

    private long timestamp = new Timestamp(new Date().getTime()).getTime();
    private int status;
    private String error;
    private String message;
    private Object payload;
    private int currentPage;
    private long totalItems;
    private int totalPages;

}
