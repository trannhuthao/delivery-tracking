package vn.kase.service.v1.user;

import vn.kase.dto.v1.model.user.AddressDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface AddressService {
    void add(AddressDto addressDto);

    List<AddressDto> findAll();
    
    Page<AddressDto> findAllPaginated(int page, int size, String sortField, String sortDirection);

    AddressDto findById(Long id);

    void update(AddressDto addressDto);

    void delete(Long id);
}