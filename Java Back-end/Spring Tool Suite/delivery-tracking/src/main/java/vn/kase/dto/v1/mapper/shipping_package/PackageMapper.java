package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.User;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.model.shipping_package.PackageDto;

public class PackageMapper {
    public static PackageDto toDto(Package shippingPackage) {
        return new PackageDto(
                shippingPackage.getId(),
                shippingPackage.getPackageName(),
                shippingPackage.getImage(),
                shippingPackage.getWeight().getId(),
                shippingPackage.getWeight().getWeightRange(),
                shippingPackage.getBoxSize().getId(),
                shippingPackage.getBoxSize().getBoxSize(),
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
        shippingPackage.setWeight(new Weight(shippingPackageDto.getWeightId()));
        shippingPackage.setBoxSize(new BoxSize(shippingPackageDto.getBoxSizeId()));
        shippingPackage.setDescription(shippingPackageDto.getDescription());
        shippingPackage.setUser(new User(shippingPackageDto.getUserId()));
        shippingPackage.setOrderDetail(new OrderDetail(shippingPackageDto.getOrderDetailId()));
        return shippingPackage;
    }
}