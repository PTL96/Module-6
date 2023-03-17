package shoe.shop.principle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shoe.shop.entity.account.Account;
import shoe.shop.repository.IAccountRepository;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        return AccountPrinciple.build(account);
    }
}
