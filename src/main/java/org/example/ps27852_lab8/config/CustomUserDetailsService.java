package org.example.ps27852_lab8.config;
import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> result = accountRepository.findById(username);
        Account account = result.orElse(null);
        if(account == null){
            return null;
        }
        List<GrantedAuthority> roleName = account.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().getName()))
                .collect(Collectors.toList());
        return User.builder()
                .username(username)
                .password(account.getPassword())
                .authorities(roleName)
                .build();
    }
}
