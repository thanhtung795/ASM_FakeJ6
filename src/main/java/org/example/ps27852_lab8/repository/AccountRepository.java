package org.example.ps27852_lab8.repository;

import org.example.ps27852_lab8.entity.Account;
import org.example.ps27852_lab8.entity.CustomerSpending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct ar.account from Authority ar where ar.role.name IN ('DIRE','STAF')")
    List<Account> getAllAcountAdmin();

    @Query("SELECT new org.example.ps27852_lab8.entity.CustomerSpending(a.fullname, SUM(od.quantity), SUM(od.price * od.quantity)) " +
            "FROM Account a " +
            "JOIN a.orders o " +
            "JOIN o.orderDetails od " +
            "GROUP BY a.fullname " +
            "ORDER BY SUM(od.price * od.quantity) DESC")
    List<CustomerSpending> getHighestSpendingCustomers();
}

