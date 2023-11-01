package com.brutech.secure_rest_api.controller;

import com.brutech.secure_rest_api.entity.Account;
import com.brutech.secure_rest_api.entity.Member;
import com.brutech.secure_rest_api.service.AccountService;
import com.brutech.secure_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private UserService userService;
    @Autowired
    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }



    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }
    @PostMapping("/{id}")
    public Account save(@RequestBody Account account, @PathVariable long id){
        Member member= userService.findById(id);
        account.setMember(member);
        member.addAccount(account);
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
