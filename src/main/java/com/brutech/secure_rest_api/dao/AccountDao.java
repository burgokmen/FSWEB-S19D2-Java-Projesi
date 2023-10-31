package com.brutech.secure_rest_api.dao;

import com.brutech.secure_rest_api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}
