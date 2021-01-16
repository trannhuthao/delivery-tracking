package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.User;
import vn.kase.dto.v1.model.UserDto;

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
                user.getAddress(),
                user.getRoles(),
                user.getOrderDetails(),
                user.getPackages(),
                user.getDeliveryAddress()
        );
    }

    public static User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getFullName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getDateOfBirth(),
                userDto.getAddress(),
                userDto.getRoles(),
                userDto.getOrderDetails(),
                userDto.getPackages(),
                userDto.getDeliveryAddress()
        );
    }
}