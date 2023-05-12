package com.example.reputationjobbe.service;

import com.example.reputationjobbe.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAccountService {

    Account findByAccount(String userName);
}
