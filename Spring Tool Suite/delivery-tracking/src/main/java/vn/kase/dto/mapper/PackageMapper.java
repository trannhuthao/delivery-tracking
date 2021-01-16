package vn.kase.dto.mapper;

import vn.kase.domain.Package;
import vn.kase.dto.model.PackageDto;

public class PackageMapper {
    public static PackageDto toDto(Package shippingPackage) {
        return new PackageDto(
                shippingPackage.getId(),
                shippingPackage.getPackageName(),
                shippingPackage.getImage(),
                shippingPackage.getWeight(),
                shippingPackage.getBoxSize(),
                shippingPackage.getDescription(),
                shippingPackage.getUser(),
                shippingPackage.getOrderDetail()
        );
    }

    public static Package toEntity(PackageDto shippingPackageDto) {
        return new Package(
                shippingPackageDto.getId(),
                shippingPackageDto.getPackageName(),
                shippingPackageDto.getImage(),
                shippingPackageDto.getWeight(),
                shippingPackageDto.getBoxSize(),
                shippingPackageDto.getDescription(),
                shippingPackageDto.getUser(),
                shippingPackageDto.getOrderDetail()
        );
    }
}