package vn.kase.dto.mapper;

import vn.kase.domain.Role;
import vn.kase.dto.model.RoleDto;

public class RoleMapper {
    public static RoleDto toDto(Role role) {
        return new RoleDto(
                role.getId(),
                role.getRoleName(),
                role.getDescription(),
                role.getUsers()
        );
    }

    public static Role toEntity(RoleDto roleDto) {
        return new Role(
                roleDto.getId(),
                roleDto.getRoleName(),
                roleDto.getDescription(),
                roleDto.getUsers()
        );
    }
}