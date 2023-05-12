package com.example.reputationjobbe.service.impl;

import com.example.reputationjobbe.model.Account;
import com.example.reputationjobbe.repository.IAccountRepository;
import com.example.reputationjobbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Account findByAccount(String userName) {
        return accountRepository.findByUsernameContaining(userName);
    }
}
