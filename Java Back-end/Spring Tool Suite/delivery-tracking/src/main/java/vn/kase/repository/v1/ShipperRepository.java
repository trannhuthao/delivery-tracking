package vn.kase.repository.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.Shipper;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    List<Shipper> findAllByFullName(String fullName);
}