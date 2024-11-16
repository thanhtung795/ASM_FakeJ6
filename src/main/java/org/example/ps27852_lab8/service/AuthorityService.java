package org.example.ps27852_lab8.service;

import org.example.ps27852_lab8.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> getAllAuthoritiesOfAdmin();
    List<Authority> getAllAuthorities();
    Authority saveAuthority(Authority authority);

    void deleteAuthority(Integer id);
}
