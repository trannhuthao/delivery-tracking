package vn.kase.service.v1;

import vn.kase.dto.v1.model.RoleDto;
import vn.kase.dto.v1.model.ShipperDto;
import vn.kase.dto.v1.model.UserDto;

import java.util.List;

public interface UserService {
    void add(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void update(UserDto userDto);

    void delete(Long id);
}