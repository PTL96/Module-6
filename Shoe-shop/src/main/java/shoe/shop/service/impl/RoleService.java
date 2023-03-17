package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.entity.account.Role;
import shoe.shop.entity.account.RoleName;
import shoe.shop.repository.IRoleRepository;
import shoe.shop.service.IRoleService;

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
