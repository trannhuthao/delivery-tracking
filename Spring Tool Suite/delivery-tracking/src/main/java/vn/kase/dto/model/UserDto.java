package vn.kase.dto.model;

import lombok.*;
import vn.kase.domain.DeliveryAddress;
import vn.kase.domain.OrderDetail;
import vn.kase.domain.Package;
import vn.kase.domain.Role;

import javax.persistence.*;
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

    private List<Package> packages = new ArrayList<Package>();

    private DeliveryAddress deliveryAddress;
}