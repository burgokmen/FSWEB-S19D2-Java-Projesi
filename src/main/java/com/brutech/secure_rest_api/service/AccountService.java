package com.brutech.secure_rest_api.service;

import com.brutech.secure_rest_api.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(Long id);
    Account save(Account account);
    Account deleteById(Long id);

}
