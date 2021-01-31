package vn.kase.service.v1.user;

import vn.kase.dto.v1.model.user.AddressDto;

import java.util.List;

public interface AddressService {
    void add(AddressDto addressDto);

    List<AddressDto> findAll();

    AddressDto findById(Long id);

    void update(AddressDto addressDto);

    void delete(Long id);
}