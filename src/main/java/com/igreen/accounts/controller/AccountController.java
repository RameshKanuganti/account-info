package com.igreen.accounts.controller;

import com.igreen.accounts.servcieI.AccountServiceI;
import com.igreen.accounts.util.AccountResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountServiceI accountServiceI;

    @ApiOperation(value = "Retrieves all accounts")
    @GetMapping("/accounts/{userId}")
    public AccountResponse getAllAccounts(@ApiParam(value = "userId of customer")
                                          @PathVariable final Long userId ,
                                          @RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "4") Integer pageSize) throws Exception {
        return accountServiceI.getAllAccounts(userId, pageNo, pageSize);
    }

    @ApiOperation(value = "Retrieval of account transactions")
    @GetMapping("/accounts/{accountNumber}/transactions")
    public AccountResponse getAccountTransactions(
            @ApiParam(value = "customer account number", required = true) @PathVariable final Long accountNumber,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize) throws Exception {
        return accountServiceI.getAccountTransactions(accountNumber, pageNo, pageSize);
    }

}
