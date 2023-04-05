package com.example.shoeshopbackend.repository;


import com.example.shoeshopbackend.entity.account.Role;
import com.example.shoeshopbackend.entity.account.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
