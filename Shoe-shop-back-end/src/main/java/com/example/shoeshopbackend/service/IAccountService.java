package com.example.shoeshopbackend.service;


import com.example.shoeshopbackend.entity.account.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);

    boolean existsAccountByEmail(String email);

    boolean existsAccountByUsername(String username);

    Account findById(Long id);

    void save(Account account);
}
