package com.igreen.accounts.servcieI;

import com.igreen.accounts.exception.APIException;
import com.igreen.accounts.exception.BadRequestException;
import com.igreen.accounts.util.AccountResponse;

public interface AccountServiceI {

    AccountResponse getAllAccounts(Long userId, Integer pageNo, Integer pageSize) throws APIException, BadRequestException;

    AccountResponse getAccountTransactions(Long accountNumber, Integer pageNo, Integer pageSize) throws APIException, BadRequestException;
}
