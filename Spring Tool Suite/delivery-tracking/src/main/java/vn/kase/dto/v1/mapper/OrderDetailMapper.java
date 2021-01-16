package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.dto.v1.model.OrderDetailDto;

public class OrderDetailMapper {
    public static OrderDetailDto toDto(OrderDetail orderDetail) {
        return new OrderDetailDto(
                orderDetail.getId(),
                orderDetail.getUser(),
                orderDetail.getShippingPackage(),
                orderDetail.getStatus(),
                orderDetail.getShipper()
        );
    }

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        return new OrderDetail(
                orderDetailDto.getId(),
                orderDetailDto.getUser(),
                orderDetailDto.getShippingPackage(),
                orderDetailDto.getStatus(),
                orderDetailDto.getShipper()
        );
    }
}