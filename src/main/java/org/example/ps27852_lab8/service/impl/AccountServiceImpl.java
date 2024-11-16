package org.example.ps27852_lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.repository.AccountRepository;
import org.example.ps27852_lab8.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findById(username).orElse(null);
        return account;
    }

    @Override
    public List<Account> getAllAcountAdmin() {
        return accountRepository.getAllAcountAdmin();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
