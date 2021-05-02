package com.igreen.accounts.model;

import com.igreen.accounts.enums.TransactionTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class AccountTransactions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long accountNumber;

    @NotNull
    private String accountName;

    private Timestamp valueDate;

    @NotNull
    private String currency;

    private Long debitAmount;

    private Long creditAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum transactionType;

    private String transactionNarrative;

}
