package shoe.shop.principle;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import shoe.shop.entity.account.Account;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AccountPrinciple implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;

    public AccountPrinciple() {
    }

    public AccountPrinciple(Long id, String username, String password, String name, String email, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public static AccountPrinciple build(Account account) {
        List<GrantedAuthority> authorityList = account.getRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new AccountPrinciple(
                account.getAccountId(),
                account.getUserName(),
                account.getPassword(),
                account.getName(),
                account.getEmail(),
                account.getAvatar(),
                authorityList
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
