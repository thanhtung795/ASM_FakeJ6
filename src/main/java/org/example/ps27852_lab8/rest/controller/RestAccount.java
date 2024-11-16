package org.example.ps27852_lab8.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/accounts")
@RequiredArgsConstructor
public class RestAccount {
    private final AccountService accountService;
    @GetMapping
    public List<Account> listAccounts(@RequestParam("admin")Optional<Boolean> admin) {
        if(admin.orElse(false)) {
            return accountService.getAllAcountAdmin();
        }
        return accountService.getAllAccounts();
    }

}
