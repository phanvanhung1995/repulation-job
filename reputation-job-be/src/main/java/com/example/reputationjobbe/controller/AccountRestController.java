package com.example.reputationjobbe.controller;

import com.example.reputationjobbe.model.Account;
import com.example.reputationjobbe.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
@CrossOrigin("*")
public class AccountRestController {
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/detail/{userName}")
    public ResponseEntity<Account> getAccount(@PathVariable String username) {
        Account account = accountService.findByAccount(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
