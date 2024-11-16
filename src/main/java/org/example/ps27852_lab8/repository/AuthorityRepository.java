package org.example.ps27852_lab8.repository;

import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query("select distinct a from Authority a where a.account IN ?1")
    List<Authority> findAuthoritiesByAccount(List<Account> accounts);
}
