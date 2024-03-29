package com.example.shoeshopbackend.controller;

import com.example.shoeshopbackend.dto.response.JwtResponse;
import com.example.shoeshopbackend.dto.response.ResponseMessage;
import com.example.shoeshopbackend.dto.resquest.SignInForm;
import com.example.shoeshopbackend.dto.resquest.SignUpForm;
import com.example.shoeshopbackend.entity.account.Account;
import com.example.shoeshopbackend.entity.account.Role;
import com.example.shoeshopbackend.entity.account.RoleName;
import com.example.shoeshopbackend.jwt.JWTProvider;
import com.example.shoeshopbackend.principle.AccountPrinciple;
import com.example.shoeshopbackend.service.IAccountService;
import com.example.shoeshopbackend.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthRestController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = accountPrinciple.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(token,
                accountPrinciple.getName(),
                accountPrinciple.getId(),
                accountPrinciple.getUsername(),
                accountPrinciple.getEmail(),
                accountPrinciple.getAvatar(),
                accountPrinciple.getIdCard(),
                accountPrinciple.getAddress(),
                accountPrinciple.getDateOfBirth(),
                accountPrinciple.getPhoneNumber(),
                roles));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (iAccountService.existsAccountByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Tên đăng nhập " + signUpForm.getUsername() +
                    " đã được sử dụng, vui lòng chọn tên khác"), HttpStatus.BAD_REQUEST);
        }
        if (iAccountService.existsAccountByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email đã tồn tại"), HttpStatus.BAD_REQUEST);
        }
        Account account = new Account(signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getName(), signUpForm.getEmail());
        Set<Role> roles = new HashSet<>();
        Role role = iRoleService.findByName(RoleName.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(role);
        account.setRoleSet(roles);
        iAccountService.save(account);
        return new ResponseEntity<>(new ResponseMessage("Đăng kí thành công"), HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> register(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iAccountService.findById(id), HttpStatus.ACCEPTED);

    }

    @PutMapping("account/{id}")
    public ResponseEntity<Account> update(@PathVariable("id") Long id, @RequestBody Account account) {
        Account account1 = iAccountService.findById(id);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        account.setAccountId(account1.getAccountId());
        iAccountService.save(account);
        return new ResponseEntity<>(iAccountService.findById(id), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> finById(@PathVariable("id") Long id) {
        Account account = iAccountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}