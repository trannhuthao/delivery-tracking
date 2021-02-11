package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.user.User;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.model.shipping_package.PackageDto;

public class PackageMapper {
    public static PackageDto toDto(Package shippingPackage) {
        PackageDto packageDto = new PackageDto();
        packageDto.setId(shippingPackage.getId());
        packageDto.setPackageName(shippingPackage.getPackageName());
        packageDto.setWeightId(shippingPackage.getWeight().getId());
        packageDto.setWeightRange(shippingPackage.getWeight().getWeightRange());
        packageDto.setBoxSizeId(shippingPackage.getBoxSize().getId());
        packageDto.setBoxSize(shippingPackage.getBoxSize().getBoxSize());
        packageDto.setDescription(shippingPackage.getDescription());
        packageDto.setStatus(shippingPackage.getStatus());
        packageDto.setUserId(shippingPackage.getUser().getId());
        packageDto.setUsername(shippingPackage.getUser().getUsername());
        packageDto.setUserFullname(shippingPackage.getUser().getFullName());
        packageDto.setUserEmail(shippingPackage.getUser().getEmail());
        packageDto.setUserPhoneNumber(shippingPackage.getUser().getPhoneNumber());
        packageDto.setUserAddressId(shippingPackage.getUser().getAddress().getId());
        packageDto.setUserAddress(shippingPackage.getUser().getAddress().getAddress());
        return packageDto;
    }

    public static Package toEntity(PackageDto shippingPackageDto) {
        Package shippingPackage = new Package();
        shippingPackage.setId(shippingPackageDto.getId());
        shippingPackage.setPackageName(shippingPackageDto.getPackageName());
//        shippingPackage.setImage(shippingPackageDto.getImage());
        shippingPackage.setWeight(new Weight(shippingPackageDto.getWeightId()));
        shippingPackage.setBoxSize(new BoxSize(shippingPackageDto.getBoxSizeId()));
        shippingPackage.setDescription(shippingPackageDto.getDescription());
        shippingPackage.setStatus(shippingPackageDto.getStatus());
        shippingPackage.setUser(new User(shippingPackageDto.getUserId()));
        return shippingPackage;
    }
}