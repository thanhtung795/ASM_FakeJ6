package org.example.ps27852_lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.entity.Authority;
import org.example.ps27852_lab8.repository.AccountRepository;
import org.example.ps27852_lab8.repository.AuthorityRepository;
import org.example.ps27852_lab8.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AccountRepository accountRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public List<Authority> getAllAuthoritiesOfAdmin() {
        List<Account> accounts = accountRepository.findAll();
        return authorityRepository.findAuthoritiesByAccount(accounts);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority saveAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteAuthority(Integer id) {
        authorityRepository.deleteById(id);
    }
}
