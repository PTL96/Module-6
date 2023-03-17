package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shoe.shop.entity.account.Account;
import shoe.shop.repository.IAccountRepository;
import shoe.shop.service.IAccountService;

import java.util.Optional;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Optional<Account> findByUsername(String username) {
        return iAccountRepository.findByUsername(username);
    }
    @Autowired
    private PasswordEncoder passwordEncoder;


}
