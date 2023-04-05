package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.entity.account.Account;
import com.example.shoeshopbackend.repository.IAccountRepository;
import com.example.shoeshopbackend.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Optional<Account> findByUsername(String username) {
        return iAccountRepository.findByUsername(username);
    }

    @Override
    public boolean existsAccountByEmail(String email) {
        return iAccountRepository.existsAccountByEmail(email);
    }

    @Override
    public boolean existsAccountByUsername(String username) {
        return iAccountRepository.existsAccountByUsername(username);
    }

    @Override
    public Account findById(Long id) {
        return iAccountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


}
