package com.igreen.accounts.repository;

import com.igreen.accounts.model.AccountTransactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactions, Long> {

    Page<AccountTransactions> findAllByAccountNumber(Long accountNumber, Pageable pageable);

}