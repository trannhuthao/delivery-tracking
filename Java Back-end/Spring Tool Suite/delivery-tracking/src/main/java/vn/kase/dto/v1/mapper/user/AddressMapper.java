package vn.kase.dto.v1.mapper.user;

import vn.kase.domain.v1.user.Address;
import vn.kase.dto.v1.model.user.AddressDto;

public class AddressMapper {
    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setAddress(address.getAddress());
        addressDto.setUsers(address.getUsers());
        return addressDto;
    }

    public static Address toEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddress(addressDto.getAddress());
        address.setUsers(addressDto.getUsers());
        return address;
    }
}