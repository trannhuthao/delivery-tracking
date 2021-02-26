package vn.kase.service.v1;

import vn.kase.dto.v1.model.RoleDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface RoleService {
    void add(RoleDto roleDto);

    List<RoleDto> findAll();

    Page<RoleDto> findAllPaginated(int page, int size, String sortField, String sortDirection);

    RoleDto findById(Long id);

    List<RoleDto> searchByRoleName(String description);

    List<RoleDto> searchByDescription(String description);

    void update(RoleDto roleDto);

    void delete(Long id);
}