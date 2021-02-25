package vn.kase.service.v1.shipping_package;

import vn.kase.dto.v1.model.shipping_package.PackageDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface PackageService {
    void add(PackageDto packageDto);

    List<PackageDto> findAll();

    Page<PackageDto> findAllPaginated(int page, int size, String sortField, String sortDirection);

    PackageDto findById(Long id);

    void update(PackageDto packageDto);

    void delete(Long id);
}