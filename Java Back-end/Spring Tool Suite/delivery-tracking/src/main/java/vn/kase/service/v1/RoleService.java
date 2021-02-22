package vn.kase.service.v1;

import vn.kase.dto.v1.model.RoleDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface RoleService {
    void add(RoleDto roleDto);

    List<RoleDto> findAll();
    
    Page<RoleDto> findAllPaginated(int page, int size);

    RoleDto findById(Long id);

    void update(RoleDto roleDto);

    void delete(Long id);
}