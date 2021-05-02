package com.igreen.accounts;

import com.igreen.accounts.exception.BadRequestException;
import com.igreen.accounts.model.AccountTransactions;
import com.igreen.accounts.model.Accounts;
import com.igreen.accounts.repository.AccountTransactionRepository;
import com.igreen.accounts.repository.AccountsRepository;
import com.igreen.accounts.servcieImpl.AccountServiceImpl;
import com.igreen.accounts.util.AccountResponse;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private AccountTransactionRepository transactionRepository;

    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getAllAccountsSuccess() throws BadRequestException {
        when(accountsRepository.findAllByUserId(any(), org.mockito.Matchers.isA(Pageable.class))).thenReturn(getAccounts());
        AccountResponse response = accountService.getAllAccounts(1L, 0, 4);
        Assertions.assertEquals("Accounts returned successfully", response.getMessage());
        Assertions.assertNotNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

 /*   @Test
    public void getAllAccounts_BadRequest() throws BadRequestException {
        expectedException.expect(BadRequestException.class);
        when(accountsRepository.findAllByUserId(any(), org.mockito.Matchers.isA(Pageable.class))).thenReturn(null);
        AccountResponse response = accountService.getAllAccounts(0L, 0, 4);
        Assertions.assertNotNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }*/

    @Test
    public void getEmptyAccounts_Test() throws BadRequestException {
        when(accountsRepository.findAllByUserId(any(), org.mockito.Matchers.isA(Pageable.class))).thenReturn(getEmptyAccounts());
        AccountResponse response = accountService.getAllAccounts(10L, 0, 4);
        Assertions.assertEquals("No accounts found", response.getMessage());
        Assertions.assertNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getAccountTransactionsSuccess() throws BadRequestException {
        when(transactionRepository.findAllByAccountNumber(any(), any())).thenReturn(getAccountTransactions());
        AccountResponse response = accountService.getAccountTransactions(123456L, 0, 4);
        Assertions.assertEquals("Account transactions retrieved successfully", response.getMessage());
        Assertions.assertNotNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getEmptyAccountTransactions_Test() throws BadRequestException {
        when(transactionRepository.findAllByAccountNumber(any(), any())).thenReturn(getEmptyAccountTransactions());
        AccountResponse response = accountService.getAccountTransactions(4l, 0, 4);
        Assertions.assertNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    /*@Test
    public void getAccountTransactionsBadRequest() throws BadRequestException {
        expectedException.expect(BadRequestException.class);
        AccountResponse response = accountService.getAccountTransactions(0l, 0, 4);
        Assertions.assertEquals("Invalid accountNumber", response.getMessage());
        Assertions.assertNull(response.getPayload());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }*/

    public Page<Accounts> getAccounts() {
        Accounts accounts = new Accounts();
        accounts.setId(1L);
        accounts.setAccountNumber(123456L);
        accounts.setAccountName("Savings");
        List<Accounts> accountsList = new ArrayList<>();
        accountsList.add(accounts);

        Page<Accounts> pagedResponse = new PageImpl(accountsList);
        return pagedResponse;
    }

    public Page<Accounts> getEmptyAccounts() {
        List<Accounts> accountsList = new ArrayList<>();
        Page<Accounts> pagedResponse = new PageImpl(new ArrayList());
        return pagedResponse;
    }


    public Page<AccountTransactions> getAccountTransactions() {
        AccountTransactions accountTransactions = new AccountTransactions();
        accountTransactions.setId(1L);
        accountTransactions.setAccountNumber(123456L);
        accountTransactions.setAccountName("Current Account");
        List<AccountTransactions> accountTransactionsList = new ArrayList<>();
        accountTransactionsList.add(accountTransactions);
        Page<AccountTransactions> pagedResponse = new PageImpl(accountTransactionsList);
        return pagedResponse;
    }

    public Page<AccountTransactions> getEmptyAccountTransactions() {
        List<AccountTransactions> accountTransactionsList = new ArrayList<>();
        Page<AccountTransactions> pagedResponse = new PageImpl(new ArrayList());
        return pagedResponse;
    }
}