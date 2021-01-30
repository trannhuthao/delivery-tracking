package vn.kase.dto.v1.mapper.shipping_package;

import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.model.shipping_package.WeightDto;

public class WeightMapper {
    public static WeightDto toDto(Weight weight) {
        WeightDto weightDto = new WeightDto();
        weightDto.setId(weight.getId());
        weightDto.setPackageId(weight.getShippingPackage().getId());
        weightDto.setPackageName(weight.getShippingPackage().getPackageName());
        weightDto.setPackageImage(weight.getShippingPackage().getImage());
        weightDto.setWeightRange(weight.getWeightRange());
        weightDto.setBoxSizeId(weight.getShippingPackage().getBoxSize().getId());
        weightDto.setBoxSize(weight.getShippingPackage().getBoxSize().getBoxSize());
        weightDto.setDescription(weight.getShippingPackage().getDescription());
        weightDto.setUserId(weight.getShippingPackage().getUser().getId());
        weightDto.setUserFullname(weight.getShippingPackage().getUser().getFullName());
        weightDto.setUsername(weight.getShippingPackage().getUser().getUsername());
        weightDto.setUserEmail(weight.getShippingPackage().getUser().getEmail());
        weightDto.setUserPhoneNumber(weight.getShippingPackage().getUser().getPhoneNumber());
        weightDto.setUserDateOfBirth(weight.getShippingPackage().getUser().getDateOfBirth());
        weightDto.setUserAddress(weight.getShippingPackage().getUser().getAddress());
        weightDto.setUserRoleId(weight.getShippingPackage().getUser().getRole().getId());
        weightDto.setUserRoleName(weight.getShippingPackage().getUser().getRole().getRoleName());
        return weightDto;
    }

    public static Weight toEntity(WeightDto weightDto) {
        Weight weight = new Weight();
        weight.setId(weightDto.getId());
        weight.setShippingPackage(new Package(weightDto.getPackageId()));
        weight.setWeightRange(weightDto.getWeightRange());
        return weight;
    }
}