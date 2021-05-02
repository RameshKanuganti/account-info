INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency,
opening_available_balance)
VALUES (1, 1, '123456', 'AUDCurrent', 'Current', now(), 'AUD', 100),
(2, 1, '112233', 'INRSavings', 'Savings', now(), 'INR', 200),
(3, 2, '112233', 'INRSavings', 'Savings', now(), 'INR', 200),
(4, 1, '111222', 'USDSavings', 'Savings', now(), 'USD', 300);

INSERT INTO ACCOUNT_TRANSACTIONS(id, account_number, account_name, value_date, currency, debit_amount, credit_amount,
transaction_type)
VALUES (1, '123456', 'Current Account', now(), 'AUD', 0, 1000, 'CREDIT'),
(2, '112233', 'Current Account', now(), 'INR', 0, 1000, 'CREDIT'),
(3, '111222', 'Current Account', now(), 'USD', 0, 1000, 'CREDIT'),
(4, '123456', 'Savinngs Account', now(), 'AUD', 0, 1000, 'CREDIT'),
(5, '123456', 'Current Account', now(), 'AUD', 1000, 0, 'DEBIT'),
(6, '123456', 'Credit Account', now(), 'AUD', 50, 0, 'DEBIT');