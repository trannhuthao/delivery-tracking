package vn.kase.repository.v1.shipping_package;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.shipping_package.Weight;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
}