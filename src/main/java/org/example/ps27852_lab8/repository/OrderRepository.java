package org.example.ps27852_lab8.repository;

import org.example.ps27852_lab8.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.account.username = ?1")
    List<Order> getAllOrderByUsername(String username);
}
