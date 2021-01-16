package vn.kase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}