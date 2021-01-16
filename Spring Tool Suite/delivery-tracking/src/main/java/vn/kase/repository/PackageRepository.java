package vn.kase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.kase.domain.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
}