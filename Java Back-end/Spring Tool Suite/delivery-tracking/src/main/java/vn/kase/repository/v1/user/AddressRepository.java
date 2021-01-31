package vn.kase.repository.v1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.user.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}