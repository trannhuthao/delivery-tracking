package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kase.domain.v1.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.dto.v1.mapper.PackageMapper;
import vn.kase.dto.v1.mapper.ShipperMapper;
import vn.kase.dto.v1.model.PackageDto;
import vn.kase.dto.v1.model.RoleDto;
import vn.kase.dto.v1.model.ShipperDto;
import vn.kase.repository.v1.ShipperRepository;
import vn.kase.service.v1.ShipperService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipperServiceImpl implements ShipperService {
    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperServiceImpl(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @Override
    public void add(ShipperDto shipperDto) {
        this.shipperRepository.save(ShipperMapper.toEntity(shipperDto));
    }

    @Override
    public List<ShipperDto> findAll() {
        List<Shipper> shippers = this.shipperRepository.findAll();
        List<ShipperDto> shipperDtos = new ArrayList<ShipperDto>();
        for (Shipper shipper : shippers) {
            shipperDtos.add(ShipperMapper.toDto(shipper));
        }

        return shipperDtos;
    }

    @Override
    public ShipperDto findById(Long id) {
        return ShipperMapper.toDto(this.shipperRepository.findById(id).get());
    }

    @Override
    public void update(ShipperDto shipperDto) {
        Shipper shipper = this.shipperRepository.findById(shipperDto.getId()).get();
        shipper.setOrderDetailList(shipperDto.getOrderDetailList());
        this.shipperRepository.save(shipper);
    }

    @Override
    public void delete(Long id) {
        this.shipperRepository.deleteById(id);
    }
}