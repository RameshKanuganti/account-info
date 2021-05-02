package com.igreen.accounts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Accounts extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @JsonIgnore
    private Long userId;

    @NotNull
    private Long accountNumber;

    @NotNull
    private String accountName;

    @NotNull
    private String accountType;

    private Timestamp balanceDate;

    @NotNull
    private String currency;

    @NotNull
    private Long openingAvailableBalance;

}
