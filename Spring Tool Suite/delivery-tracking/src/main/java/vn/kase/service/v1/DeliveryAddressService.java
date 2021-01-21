package vn.kase.service.v1;

import vn.kase.dto.v1.model.DeliveryAddressDto;
import vn.kase.dto.v1.model.PackageDto;

import java.util.List;

public interface DeliveryAddressService {
    void add(DeliveryAddressDto deliveryAddressDto);

    List<DeliveryAddressDto> findAll();

    DeliveryAddressDto findById(Long id);

    void update(DeliveryAddressDto deliveryAddressDto);

    void delete(Long id);
}