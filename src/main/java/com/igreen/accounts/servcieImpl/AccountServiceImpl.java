package com.igreen.accounts.servcieImpl;

import com.igreen.accounts.exception.BadRequestException;
import com.igreen.accounts.model.AccountTransactions;
import com.igreen.accounts.model.Accounts;
import com.igreen.accounts.repository.AccountTransactionRepository;
import com.igreen.accounts.repository.AccountsRepository;
import com.igreen.accounts.servcieI.AccountServiceI;
import com.igreen.accounts.util.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountServiceI {

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public AccountResponse getAllAccounts(Long userId, Integer pageNo, Integer pageSize) throws BadRequestException {
        AccountResponse response = new AccountResponse();
        if (userId <= 0) {
            response.setMessage("Input validation failed");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setError("Invalid userId provided");
            throw new BadRequestException(response);
        }
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Accounts> accountsList = accountsRepository.findAllByUserId(userId, paging);

        if (accountsList.hasContent()) {
            response.setMessage("Accounts returned successfully");
            response.setStatus(HttpStatus.OK.value());
            response.setPayload(accountsList.getContent());
            response.setCurrentPage(accountsList.getNumber());
            response.setTotalPages(accountsList.getTotalPages());
            response.setTotalItems(accountsList.getTotalElements());
            return response;
        } else {
            response.setMessage("No accounts found");
            response.setStatus(HttpStatus.OK.value());
            return response;
        }
    }

    @Override
    public AccountResponse getAccountTransactions(Long accountNumber, Integer pageNo, Integer pageSize) throws BadRequestException {
        AccountResponse response = new AccountResponse();
        if (accountNumber <= 0) {
            response.setMessage("Input validation failed");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setError("Invalid account number provided");
            throw new BadRequestException(response);
        }
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<AccountTransactions> accountTransactions = accountTransactionRepository.findAllByAccountNumber(accountNumber, paging);
        if (accountTransactions.hasContent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Account transactions retrieved successfully");
            response.setPayload(accountTransactions.getContent());
            response.setCurrentPage(accountTransactions.getNumber());
            response.setTotalPages(accountTransactions.getTotalPages());
            response.setTotalItems(accountTransactions.getTotalElements());
            return response;
        } else {
            response.setMessage("No transaction data for provided account");
            response.setStatus(HttpStatus.OK.value());
            return response;
        }
    }
}