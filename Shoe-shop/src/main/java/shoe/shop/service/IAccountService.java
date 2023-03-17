package shoe.shop.service;

import shoe.shop.entity.account.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);

}
