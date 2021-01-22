package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.DeliveryAddress;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.Package;
import vn.kase.domain.v1.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDto {
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Date dateOfBirth;

    private String address;

    private List<Role> roles = new ArrayList<Role>();

    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    private List<Package> shippingPackages = new ArrayList<Package>();

    private DeliveryAddress deliveryAddress;
}