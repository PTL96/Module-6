package shoe.shop.service;

import shoe.shop.entity.account.Role;
import shoe.shop.entity.account.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
