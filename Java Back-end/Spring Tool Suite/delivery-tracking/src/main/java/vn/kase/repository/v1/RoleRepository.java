package vn.kase.repository.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}