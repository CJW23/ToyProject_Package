package com.cjw.security.repository;

import com.cjw.security.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
}
