package vn.kase.service.v1.shipping_package;

import vn.kase.dto.v1.model.shipping_package.PackageDto;

import java.util.List;

public interface PackageService {
    void add(PackageDto packageDto);

    List<PackageDto> findAll();

    PackageDto findById(Long id);

    void update(PackageDto packageDto);

    void delete(Long id);
}