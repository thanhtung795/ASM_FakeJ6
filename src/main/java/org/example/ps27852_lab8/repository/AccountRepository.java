package org.example.ps27852_lab8.repository;

import org.example.ps27852_lab8.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct ar.account from Authority ar where ar.role.name IN ('DIRE','STAF')")
    List<Account> getAllAcountAdmin();

}
