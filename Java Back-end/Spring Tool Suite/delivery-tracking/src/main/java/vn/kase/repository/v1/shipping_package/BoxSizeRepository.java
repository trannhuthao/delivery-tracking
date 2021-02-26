package vn.kase.repository.v1.shipping_package;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.v1.shipping_package.BoxSize;

import java.util.List;

@Repository
public interface BoxSizeRepository extends JpaRepository<BoxSize, Long> {
    List<BoxSize> findAllByBoxSize(String boxSize);
}