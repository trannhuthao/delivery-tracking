package vn.kase.dto.mapper;

import vn.kase.domain.Shipper;
import vn.kase.dto.model.ShipperDto;

public class ShipperMapper {
    public static ShipperDto toDto(Shipper shipper) {
        return new ShipperDto(shipper.getId(), shipper.getOrderDetailList());
    }

    public static Shipper toEntity(ShipperDto shipperDto) {
        return new Shipper(shipperDto.getId(), shipperDto.getOrderDetailList());
    }
}