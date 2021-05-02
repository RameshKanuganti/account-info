package com.igreen.accounts.enums;

public enum TransactionTypeEnum {

    CREDIT("Credit"),
    DEBIT("Debit"),
    HOLD("Hold");

    private String transactionType;

    TransactionTypeEnum(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }
}