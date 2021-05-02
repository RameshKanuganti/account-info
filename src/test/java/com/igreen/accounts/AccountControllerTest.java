package com.igreen.accounts;

import com.igreen.accounts.controller.AccountController;
import com.igreen.accounts.exception.APIException;
import com.igreen.accounts.exception.BadRequestException;
import com.igreen.accounts.exception.GlobalExceptionHandler;
import com.igreen.accounts.servcieI.AccountServiceI;
import com.igreen.accounts.util.AccountResponse;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AccountControllerTest {

    @InjectMocks
    private AccountController controller;

    @Mock
    private AccountServiceI accountServiceI;

    @Mock
    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    public void setUp() {
        StandaloneMockMvcBuilder builder = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(exceptionHandler);
        RestAssuredMockMvc.standaloneSetup(builder);
    }

    @Test
    public void getAllAccounts() throws APIException, BadRequestException {
        when(accountServiceI.getAllAccounts(any(), any(), any())).thenReturn(getAccounts());
        given().when().get("/accounts/1")
                .then()
                .log().all()
                .body("message", equalTo("Account transactions retrieved successfully"))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getAccountTransactions() throws APIException, BadRequestException {
        when(accountServiceI.getAccountTransactions(any(), any(), any())).thenReturn(getAccounts());
        given().when().get("/accounts/1/transactions")
                .then()
                .log().all()
                .body("message", equalTo("Account transactions retrieved successfully"))
                .statusCode(HttpStatus.OK.value());
    }

    private AccountResponse getAccounts() {
        AccountResponse response = new AccountResponse();
        response.setMessage("Account transactions retrieved successfully");
        return response;
    }
}