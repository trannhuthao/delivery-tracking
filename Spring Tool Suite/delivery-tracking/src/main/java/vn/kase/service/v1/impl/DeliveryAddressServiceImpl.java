package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.DeliveryAddress;
import vn.kase.domain.v1.User;
import vn.kase.dto.v1.mapper.DeliveryAddressMapper;
import vn.kase.dto.v1.model.DeliveryAddressDto;
import vn.kase.repository.v1.DeliveryAddressRepository;
import vn.kase.service.v1.DeliveryAddressService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    public DeliveryAddressServiceImpl(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    @Override
    public void add(DeliveryAddressDto deliveryAddressDto) {
        this.deliveryAddressRepository.save(DeliveryAddressMapper.toEntity(deliveryAddressDto));
    }

    @Override
    public List<DeliveryAddressDto> findAll() {
        List<DeliveryAddress> deliveryAddresses = this.deliveryAddressRepository.findAll();
        List<DeliveryAddressDto> deliveryAddressDtos = new ArrayList<DeliveryAddressDto>();
        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            deliveryAddressDtos.add(DeliveryAddressMapper.toDto(deliveryAddress));
        }

        return deliveryAddressDtos;
    }

    @Override
    public DeliveryAddressDto findById(Long id) {
        return DeliveryAddressMapper.toDto(this.deliveryAddressRepository.findById(id).get());
    }

    @Override
    public void update(DeliveryAddressDto deliveryAddressDto) {
        DeliveryAddress deliveryAddress = this.deliveryAddressRepository.findById(deliveryAddressDto.getId()).get();
        deliveryAddress.setUser(new User(deliveryAddressDto.getUserId()));
        this.deliveryAddressRepository.save(deliveryAddress);
    }

    @Override
    public void delete(Long id) {
        this.deliveryAddressRepository.deleteById(id);
    }
}