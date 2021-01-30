package vn.kase.service.v1;

import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.dto.v1.model.RoleDto;

import java.util.List;

public interface RoleService {
    void add(RoleDto roleDto);

    List<RoleDto> findAll();

    RoleDto findById(Long id);

    void update(RoleDto roleDto);

    void delete(Long id);
}