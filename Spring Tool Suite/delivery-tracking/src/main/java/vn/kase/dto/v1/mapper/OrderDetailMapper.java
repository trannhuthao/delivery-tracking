package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.User;
import vn.kase.dto.v1.model.OrderDetailDto;

public class OrderDetailMapper {
    public static OrderDetailDto toDto(OrderDetail orderDetail) {
        return new OrderDetailDto(
                orderDetail.getId(),
                orderDetail.getUser().getId(),
                orderDetail.getUser().getUsername(),
                orderDetail.getUser().getFullName(),
                orderDetail.getUser().getEmail(),
                orderDetail.getUser().getPhoneNumber(),
                orderDetail.getUser().getAddress(),
                orderDetail.getShippingPackage().getId(),
                orderDetail.getShippingPackage().getPackageName(),
                orderDetail.getShippingPackage().getImage(),
                orderDetail.getShippingPackage().getWeight(),
                orderDetail.getShippingPackage().getBoxSize(),
                orderDetail.getShippingPackage().getDescription(),
                orderDetail.getStatus(),
                orderDetail.getShipper().getId()
        );
    }

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setUser(new User(orderDetailDto.getUserId()));
        orderDetail.setShippingPackage(new Package(orderDetailDto.getShippingPackageId()));
        orderDetail.setStatus(orderDetailDto.getStatus());
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        return orderDetail;
    }
}