package vn.kase.dto.mapper;

import vn.kase.domain.DeliveryAddress;
import vn.kase.dto.model.DeliveryAddressDto;

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