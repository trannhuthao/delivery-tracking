package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.kase.domain.v1.Role;
import vn.kase.dto.v1.mapper.RoleMapper;
import vn.kase.dto.v1.model.RoleDto;
import vn.kase.repository.v1.RoleRepository;
import vn.kase.service.v1.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void add(RoleDto roleDto) {
        this.roleRepository.save(RoleMapper.toEntity(roleDto));
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = this.roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<RoleDto>();
        for (Role role : roles) {
            roleDtos.add(RoleMapper.toDto(role));
        }

        return roleDtos;
    }
    
    @Override
	public Page<RoleDto> findAllPaginated(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		Page<Role> rolesPaginated = this.roleRepository.findAll(pageable);
		Page<RoleDto> roleDtosPaginated = rolesPaginated.map(element -> RoleMapper.toDto(element));

		return roleDtosPaginated;
	}

    @Override
    public RoleDto findById(Long id) {
        return RoleMapper.toDto(this.roleRepository.findById(id).get());
    }

    @Override
    public List<RoleDto> search(String description) {
        List<Role> foundRoles = this.roleRepository.findAllByDescription(description);
        List<RoleDto> foundRoleDtos = new ArrayList<RoleDto>();
        for (Role role : foundRoles) {
            foundRoleDtos.add(RoleMapper.toDto(role));
        }

        return foundRoleDtos;
    }

    @Override
    public void update(RoleDto roleDto) {
        Role role = this.roleRepository.findById(roleDto.getId()).get();
        role.setRoleName(roleDto.getRoleName());
        role.setDescription(roleDto.getDescription());
        role.setUsers(roleDto.getUsers());
        this.roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        this.roleRepository.deleteById(id);
    }
}