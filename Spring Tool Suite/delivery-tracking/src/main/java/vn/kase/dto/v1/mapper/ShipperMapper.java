package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.Shipper;
import vn.kase.dto.v1.model.ShipperDto;

public class ShipperMapper {
    public static ShipperDto toDto(Shipper shipper) {
        return new ShipperDto(shipper.getId(), shipper.getOrderDetailList());
    }

    public static Shipper toEntity(ShipperDto shipperDto) {
        return new Shipper(shipperDto.getId(), shipperDto.getOrderDetailList());
    }
}