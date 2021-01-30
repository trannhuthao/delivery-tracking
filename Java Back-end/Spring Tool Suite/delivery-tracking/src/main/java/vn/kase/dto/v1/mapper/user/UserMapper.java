package vn.kase.dto.v1.mapper.user;

import vn.kase.domain.v1.Role;
import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.model.user.UserDto;

public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getDateOfBirth(),
                user.getAddress().getId(),
                user.getAddress().getAddress(),
                user.getRole().getId(),
                user.getRole().getDescription(),
                user.getOrderDetailList(),
                user.getShippingPackages()
        );
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAddress(new Address(userDto.getAddressId()));
        user.setRole(new Role(userDto.getRoleId()));
        return user;
    }
}