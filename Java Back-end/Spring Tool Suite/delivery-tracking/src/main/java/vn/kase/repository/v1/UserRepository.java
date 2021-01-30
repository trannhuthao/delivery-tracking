package vn.kase.repository.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}