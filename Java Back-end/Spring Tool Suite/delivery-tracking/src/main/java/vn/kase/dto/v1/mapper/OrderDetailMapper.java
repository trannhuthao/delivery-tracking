package vn.kase.dto.v1.mapper;

import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.model.OrderDetailDto;

public class OrderDetailMapper {
    public static OrderDetailDto toDto(OrderDetail orderDetail) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setUserId(orderDetail.getUser().getId());
        orderDetailDto.setUsername(orderDetail.getUser().getUsername());
        orderDetailDto.setUserFullName(orderDetail.getUser().getFullName());
        orderDetailDto.setUserEmail(orderDetail.getUser().getEmail());
        orderDetailDto.setUserPhoneNumber(orderDetail.getUser().getPhoneNumber());
        orderDetailDto.setUserDateOfBirth(orderDetail.getUser().getDateOfBirth());
        orderDetailDto.setUserAddressId(orderDetail.getUser().getAddress().getId());
        orderDetailDto.setUserAddress(orderDetail.getUser().getAddress().getAddress());
        orderDetailDto.setUserRoleId(orderDetail.getUser().getRole().getId());
        orderDetailDto.setUserRoleDescription(orderDetail.getUser().getRole().getDescription());
        orderDetailDto.setShippingPackageId(orderDetail.getShippingPackage().getId());
        orderDetailDto.setPackageName(orderDetail.getShippingPackage().getPackageName());
        orderDetailDto.setWeightId(orderDetail.getShippingPackage().getWeight().getId());
        orderDetailDto.setWeightRange(orderDetail.getShippingPackage().getWeight().getWeightRange());
        orderDetailDto.setBoxSizeId(orderDetail.getShippingPackage().getBoxSize().getId());
        orderDetailDto.setBoxSize(orderDetail.getShippingPackage().getBoxSize().getBoxSize());
        orderDetailDto.setPackageDescription(orderDetail.getShippingPackage().getDescription());
        orderDetailDto.setStatus(orderDetail.getShippingPackage().getStatus());
        orderDetailDto.setPackageOwnerId(orderDetail.getShippingPackage().getUser().getId());
        orderDetailDto.setPackageOwnerUsername(orderDetail.getShippingPackage().getUser().getUsername());
        orderDetailDto.setPackageOwnerFullname(orderDetail.getShippingPackage().getUser().getFullName());
        orderDetailDto.setPackageOwnerEmail(orderDetail.getShippingPackage().getUser().getEmail());
        orderDetailDto.setPackageOwnerPhoneNumber(orderDetail.getShippingPackage().getUser().getPhoneNumber());
        orderDetailDto.setPackageOwnerDateOfBirth(orderDetail.getShippingPackage().getUser().getDateOfBirth());
        orderDetailDto.setPackageOwnerAddressId(orderDetail.getShippingPackage().getUser().getAddress().getId());
        orderDetailDto.setPackageOwnerAddress(orderDetail.getShippingPackage().getUser().getAddress().getAddress());
        orderDetailDto.setPackageOwnerRoleId(orderDetail.getShippingPackage().getUser().getRole().getId());
        orderDetailDto.setPackageOwnerRoleDescription(orderDetail.getShippingPackage().getUser().getRole().getDescription());
        orderDetailDto.setShipperId(orderDetail.getShipper().getId());
        orderDetailDto.setShipperFullName(orderDetail.getShipper().getFullName());
        orderDetailDto.setRecipientId(orderDetail.getRecipient().getId());
        orderDetailDto.setRecipientUsername(orderDetail.getRecipient().getUsername());
        orderDetailDto.setRecipientFullName(orderDetail.getRecipient().getFullName());
        orderDetailDto.setRecipientEmail(orderDetail.getRecipient().getEmail());
        orderDetailDto.setRecipientPhoneNumber(orderDetail.getRecipient().getPhoneNumber());
        orderDetailDto.setRecipientDateOfBirth(orderDetail.getRecipient().getDateOfBirth());
        orderDetailDto.setRecipientAddressId(orderDetail.getRecipient().getAddress().getId());
        orderDetailDto.setRecipientAddress(orderDetail.getRecipient().getAddress().getAddress());
        orderDetailDto.setRecipientRoleId(orderDetail.getRecipient().getRole().getId());
        orderDetailDto.setRecipientRoleDescription(orderDetail.getRecipient().getRole().getDescription());
        orderDetailDto.setTotal(orderDetail.getTotal());

        return orderDetailDto;
    }

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setUser(new User(orderDetailDto.getUserId()));
        orderDetail.setShippingPackage(new Package(orderDetailDto.getShippingPackageId()));
        orderDetail.setShipper(new Shipper(orderDetailDto.getShipperId()));
        orderDetail.setRecipient(new User(orderDetailDto.getRecipientId()));
        orderDetail.setTotal(orderDetailDto.getTotal());

        return orderDetail;
    }
}