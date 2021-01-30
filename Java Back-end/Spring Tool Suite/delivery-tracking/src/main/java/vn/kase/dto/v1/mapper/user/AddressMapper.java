package vn.kase.dto.v1.mapper.user;

import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.model.user.AddressDto;

public class AddressMapper {
    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setAddress(address.getAddress());
        addressDto.setUserId(address.getUser().getId());
        addressDto.setUserFullname(address.getUser().getFullName());
        addressDto.setUsername(address.getUser().getUsername());
        addressDto.setUserPhoneNumber(address.getUser().getPhoneNumber());
        addressDto.setUserEmail(address.getUser().getEmail());
        addressDto.setUserDateOfBirth(address.getUser().getDateOfBirth());
        addressDto.setUserRoleId(address.getUser().getRole().getId());
        addressDto.setUserRoleName(address.getUser().getRole().getRoleName());
        return addressDto;
    }

    public static Address toEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddress(addressDto.getAddress());
        address.setUser(new User(addressDto.getUserId()));
        return address;
    }
}