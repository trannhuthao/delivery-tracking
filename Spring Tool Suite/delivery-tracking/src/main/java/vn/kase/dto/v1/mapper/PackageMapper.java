package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.Package;
import vn.kase.domain.v1.User;
import vn.kase.dto.v1.model.PackageDto;

public class PackageMapper {
    public static PackageDto toDto(Package shippingPackage) {
        return new PackageDto(
                shippingPackage.getId(),
                shippingPackage.getPackageName(),
                shippingPackage.getImage(),
                shippingPackage.getWeight(),
                shippingPackage.getBoxSize(),
                shippingPackage.getDescription(),
                shippingPackage.getUser().getId(),
                shippingPackage.getUser().getUsername(),
                shippingPackage.getUser().getFullName(),
                shippingPackage.getUser().getEmail(),
                shippingPackage.getUser().getPhoneNumber(),
                shippingPackage.getUser().getAddress(),
                shippingPackage.getOrderDetail().getId(),
                shippingPackage.getOrderDetail().getStatus(),
                shippingPackage.getOrderDetail().getShipper().getId()
        );
    }

    public static Package toEntity(PackageDto shippingPackageDto) {
        Package shippingPackage = new Package();
        shippingPackage.setId(shippingPackageDto.getId());
        shippingPackage.setPackageName(shippingPackageDto.getPackageName());
        shippingPackage.setImage(shippingPackageDto.getImage());
        shippingPackage.setWeight(shippingPackageDto.getWeight());
        shippingPackage.setBoxSize(shippingPackageDto.getBoxSize());
        shippingPackage.setDescription(shippingPackageDto.getDescription());
        shippingPackage.setUser(new User(shippingPackageDto.getUserId()));
        shippingPackage.setOrderDetail(new OrderDetail(shippingPackageDto.getOrderDetailId()));
        return shippingPackage;
    }
}