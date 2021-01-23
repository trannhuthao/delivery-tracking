package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.Role;
import vn.kase.dto.v1.model.RoleDto;

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
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        role.setDescription(roleDto.getDescription());
        role.setUsers(roleDto.getUsers());
        return role;
    }
}