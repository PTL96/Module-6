package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoe.shop.entity.account.Role;
import shoe.shop.entity.account.RoleName;

import java.util.Optional;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
