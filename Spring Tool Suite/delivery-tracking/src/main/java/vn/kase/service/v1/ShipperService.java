package vn.kase.service.v1;

import vn.kase.dto.v1.model.RoleDto;
import vn.kase.dto.v1.model.ShipperDto;

import java.util.List;

public interface ShipperService {
    void add(ShipperDto shipperDto);

    List<ShipperDto> findAll();

    ShipperDto findById(Long id);

    void update(ShipperDto shipperDto);

    void delete(Long id);
}