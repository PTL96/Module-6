package com.example.shoeshopbackend.service;


import com.example.shoeshopbackend.entity.account.Role;
import com.example.shoeshopbackend.entity.account.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
