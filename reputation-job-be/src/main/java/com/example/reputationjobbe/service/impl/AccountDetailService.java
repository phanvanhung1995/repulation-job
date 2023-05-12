package com.example.reputationjobbe.service.impl;

import com.example.reputationjobbe.model.Account;
import com.example.reputationjobbe.repository.IAccountRepository;
import com.example.reputationjobbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findAccountByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return AccountDetails.build(account);
    }
}
