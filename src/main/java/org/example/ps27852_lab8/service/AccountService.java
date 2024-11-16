package org.example.ps27852_lab8.service;

import org.example.ps27852_lab8.entity.Account;

import java.util.List;

public interface AccountService {
    Account findByUsername(String username);
    List<Account> getAllAcountAdmin();
    List<Account> getAllAccounts();
}
