package vn.kase.dto.mapper;

import vn.kase.domain.OrderDetail;
import vn.kase.dto.model.OrderDetailDto;

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