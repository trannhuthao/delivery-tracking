package vn.kase.dto.v1.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String address;

    private Long roleId;

    private String roleDescription;

    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    private List<Package> shippingPackages = new ArrayList<Package>();
}