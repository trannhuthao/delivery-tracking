package vn.kase.service.v1.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.Role;
import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.mapper.user.AddressMapper;
import vn.kase.dto.v1.mapper.user.UserMapper;
import vn.kase.dto.v1.model.user.AddressDto;
import vn.kase.dto.v1.model.user.UserDto;
import vn.kase.repository.v1.user.AddressRepository;
import vn.kase.service.v1.user.AddressService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void add(AddressDto addressDto) {
        this.addressRepository.save(AddressMapper.toEntity(addressDto));
    }

    @Override
    public List<AddressDto> findAll() {
        List<Address> addresses = this.addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        for (Address address : addresses) {
            addressDtos.add(AddressMapper.toDto(address));
        }

        return addressDtos;
    }

    @Override
    public AddressDto findById(Long id) {
        return AddressMapper.toDto(this.addressRepository.findById(id).get());
    }

    @Override
    public void update(AddressDto addressDto) {
        Address address = addressRepository.findById(addressDto.getId()).get();
        address.setAddress(addressDto.getAddress());
        address.setUser(address.getUser());
        this.addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        this.addressRepository.deleteById(id);
    }
}