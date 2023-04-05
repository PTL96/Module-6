package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.entity.account.Role;
import com.example.shoeshopbackend.entity.account.RoleName;
import com.example.shoeshopbackend.repository.IRoleRepository;
import com.example.shoeshopbackend.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return iRoleRepository.findByName(name);
    }
}
