package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.user.Address;
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
                orderDetail.getUser().getRole().getId(),
                orderDetail.getUser().getRole().getDescription(),
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
                orderDetail.getShippingPackage().getUser().getDateOfBirth(),
                orderDetail.getShippingPackage().getUser().getAddress().getId(),
                orderDetail.getShippingPackage().getUser().getAddress().getAddress(),
                orderDetail.getShippingPackage().getUser().getRole().getId(),
                orderDetail.getShippingPackage().getUser().getRole().getDescription(),
                orderDetail.getShipper().getId(),
                orderDetail.getShipper().getFullName(),
                orderDetail.getRecipient().getId(),
                orderDetail.getRecipient().getUsername(),
                orderDetail.getRecipient().getFullName(),
                orderDetail.getRecipient().getEmail(),
                orderDetail.getRecipient().getPhoneNumber(),
                orderDetail.getRecipient().getDateOfBirth(),
                orderDetail.getRecipient().getAddress().getId(),
                orderDetail.getRecipient().getAddress().getAddress(),
                orderDetail.getRecipient().getRole().getId(),
                orderDetail.getRecipient().getRole().getDescription()
        );
    }

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setUser(new User(orderDetailDto.getUserId()));
        orderDetail.setShippingPackage(new Package(orderDetailDto.getShippingPackageId()));
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        orderDetail.setRecipient(new User(orderDetailDto.getRecipientId()));
        return orderDetail;
    }
}