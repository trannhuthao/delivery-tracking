package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.DeliveryAddress;
import vn.kase.dto.v1.model.DeliveryAddressDto;

public class DeliveryAddressMapper {
    public static DeliveryAddressDto toDto(DeliveryAddress deliveryAddress) {
        return new DeliveryAddressDto(
                deliveryAddress.getId(),
                deliveryAddress.getUser()
        );
    }

    public static DeliveryAddress toEntity(DeliveryAddressDto deliveryAddressDto) {
        return new DeliveryAddress(
                deliveryAddressDto.getId(),
                deliveryAddressDto.getUser()
        );
    }
}