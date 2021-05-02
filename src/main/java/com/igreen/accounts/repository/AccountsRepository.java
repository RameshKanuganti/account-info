package com.igreen.accounts.repository;

import com.igreen.accounts.model.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Page<Accounts> findAllByUserId(Long userId, Pageable pageable);
}