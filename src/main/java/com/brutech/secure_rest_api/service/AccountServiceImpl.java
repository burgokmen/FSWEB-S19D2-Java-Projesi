package com.brutech.secure_rest_api.service;

import com.brutech.secure_rest_api.dao.AccountDao;
import com.brutech.secure_rest_api.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }



    @Override
    public Account deleteById(Long id) {
        Account account = findById(id);
        accountDao.deleteById(id);
        return account;
    }
}
