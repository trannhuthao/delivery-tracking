package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.Shipper;
import vn.kase.dto.v1.model.ShipperDto;

public class ShipperMapper {
    public static ShipperDto toDto(Shipper shipper) {
        ShipperDto shipperDto = new ShipperDto();
        shipperDto.setId(shipper.getId());
        shipperDto.setFullName(shipper.getFullName());
        shipperDto.setOrderDetailList(shipper.getOrderDetailList());
        return shipperDto;
    }

    public static Shipper toEntity(ShipperDto shipperDto) {
        Shipper shipper = new Shipper();
        shipper.setId(shipperDto.getId());
        shipper.setFullName(shipperDto.getFullName());
        shipper.setOrderDetailList(shipperDto.getOrderDetailList());
        return shipper;
    }
}