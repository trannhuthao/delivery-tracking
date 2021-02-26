package vn.kase.repository.v1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.user.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByFullName(String fullName);

    User findByEmail(String email);

    List<User> findAllByFullName(String fullName);
}