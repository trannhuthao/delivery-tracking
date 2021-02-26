package vn.kase.repository.v1.shipping_package;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.shipping_package.Weight;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findAllByWeightRange(String weightRange);
}