package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.shipping_package.BoxSize;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;

public class BoxSizeMapper {
    public static BoxSizeDto toDto(BoxSize boxSize) {
        BoxSizeDto boxSizeDto = new BoxSizeDto();
        boxSizeDto.setId(boxSize.getId());
        boxSizeDto.setShippingPackageId(boxSize.getShippingPackage().getId());
        boxSizeDto.setShippingPackageName(boxSize.getShippingPackage().getPackageName());
        boxSizeDto.setShippingPackageImage(boxSize.getShippingPackage().getImage());
        boxSizeDto.setWeightId(boxSize.getShippingPackage().getWeight().getId());
        boxSizeDto.setWeightRange(boxSize.getShippingPackage().getWeight().getWeightRange());
        boxSizeDto.setBoxSize(boxSize.getBoxSize());
        boxSizeDto.setShippingPackageDescription(boxSize.getShippingPackage().getDescription());
        boxSizeDto.setUserId(boxSize.getShippingPackage().getUser().getId());
        boxSizeDto.setUserFullname(boxSize.getShippingPackage().getUser().getFullName());
        boxSizeDto.setUsername(boxSize.getShippingPackage().getUser().getUsername());
        boxSizeDto.setUserEmail(boxSize.getShippingPackage().getUser().getEmail());
        boxSizeDto.setUserPhoneNumber(boxSize.getShippingPackage().getUser().getPhoneNumber());
        boxSizeDto.setUserDateOfBirth(boxSize.getShippingPackage().getUser().getDateOfBirth());
        boxSizeDto.setUserAddress(boxSize.getShippingPackage().getUser().getAddress());
        boxSizeDto.setRoleId(boxSize.getShippingPackage().getUser().getRole().getId());
        boxSizeDto.setRoleName(boxSize.getShippingPackage().getUser().getRole().getRoleName());
        boxSizeDto.setOrderDetailId(boxSize.getShippingPackage().getOrderDetail().getId());
        boxSizeDto.setOrderDetailStatus(boxSize.getShippingPackage().getOrderDetail().getStatus());
        boxSizeDto.setShipperId(boxSize.getShippingPackage().getOrderDetail().getShipper().getId());
        return boxSizeDto;
    }

    public static BoxSize toEntity(BoxSizeDto boxSizeDto) {
        BoxSize boxSize = new BoxSize();
        boxSize.setShippingPackage(new Package(boxSizeDto.getShippingPackageId()));
        boxSize.setBoxSize(boxSizeDto.getBoxSize());
        return boxSize;
    }
}