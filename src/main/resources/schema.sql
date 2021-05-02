DROP
  TABLE IF EXISTS ACCOUNTS;
CREATE TABLE `ACCOUNTS` (
  `id` INT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `account_number` BIGINT NOT NULL,
  `account_name` VARCHAR(50) NOT NULL,
  `account_type` VARCHAR(10) NOT NULL,
  `balance_date` DATE NOT NULL,
  `currency` VARCHAR(10) NOT NULL,
  `opening_available_balance` VARCHAR(10),
  `created_date` DATE DEFAULT CURRENT_TIMESTAMP,
  `updated_date` DATE DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

DROP
  TABLE IF EXISTS ACCOUNT_TRANSACTIONS;
CREATE TABLE `ACCOUNT_TRANSACTIONS` (
  `id` INT NOT NULL,
  `account_number` BIGINT NOT NULL,
  `account_name` VARCHAR(50) NOT NULL,
  `value_date` DATE NOT NULL,
  `currency` VARCHAR(10) NOT NULL,
  `debit_amount` BIGINT NOT NULL,
  `credit_amount` BIGINT NOT NULL,
  `transaction_type` VARCHAR(10) NOT NULL,
  `transaction_narrative` VARCHAR(10),
  `created_date` DATE DEFAULT CURRENT_TIMESTAMP,
  `updated_date` DATE DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);
