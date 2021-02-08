package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.user.User;
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
                orderDetail.getUser().getDateOfBirth(),
                orderDetail.getUser().getAddress().getId(),
                orderDetail.getUser().getAddress().getAddress(),
                orderDetail.getShippingPackage().getId(),
                orderDetail.getShippingPackage().getPackageName(),
//                orderDetail.getShippingPackage().getImage(),
                orderDetail.getShippingPackage().getWeight().getId(),
                orderDetail.getShippingPackage().getWeight().getWeightRange(),
                orderDetail.getShippingPackage().getBoxSize().getId(),
                orderDetail.getShippingPackage().getBoxSize().getBoxSize(),
                orderDetail.getShippingPackage().getDescription(),
                orderDetail.getShippingPackage().getStatus(),
                orderDetail.getShippingPackage().getUser().getId(),
                orderDetail.getShippingPackage().getUser().getUsername(),
                orderDetail.getShippingPackage().getUser().getFullName(),
                orderDetail.getShippingPackage().getUser().getEmail(),
                orderDetail.getShippingPackage().getUser().getPhoneNumber(),
                orderDetail.getShippingPackage().getUser().getAddress().getId(),
                orderDetail.getShippingPackage().getUser().getAddress().getAddress(),
                orderDetail.getShipper().getId()
        );
    }

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setUser(new User(orderDetailDto.getUserId()));
        orderDetail.setShippingPackage(new Package(orderDetailDto.getShippingPackageId()));
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        return orderDetail;
    }
}