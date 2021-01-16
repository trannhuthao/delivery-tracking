package vn.kase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}