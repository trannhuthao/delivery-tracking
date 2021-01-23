package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.DeliveryAddress;
import vn.kase.domain.v1.User;
import vn.kase.dto.v1.model.DeliveryAddressDto;

public class DeliveryAddressMapper {
    public static DeliveryAddressDto toDto(DeliveryAddress deliveryAddress) {
        return new DeliveryAddressDto(
                deliveryAddress.getId(),
                deliveryAddress.getUser().getId(),
                deliveryAddress.getUser().getUsername(),
                deliveryAddress.getUser().getFullName(),
                deliveryAddress.getUser().getEmail(),
                deliveryAddress.getUser().getPhoneNumber(),
                deliveryAddress.getUser().getAddress()
        );
    }

    public static DeliveryAddress toEntity(DeliveryAddressDto deliveryAddressDto) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(deliveryAddressDto.getId());
        deliveryAddress.setUser(new User(deliveryAddressDto.getUserId()));
        return deliveryAddress;
    }
}