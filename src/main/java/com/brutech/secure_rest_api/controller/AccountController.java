package com.brutech.secure_rest_api.controller;

import com.brutech.secure_rest_api.entity.Account;
import com.brutech.secure_rest_api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }
    @PostMapping("/")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable Long id){
        return accountService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Account deleteById(@PathVariable Long id){
        return accountService.deleteById(id);
    }
}
