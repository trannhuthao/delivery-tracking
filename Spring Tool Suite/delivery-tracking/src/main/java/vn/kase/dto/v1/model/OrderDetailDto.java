package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.Package;
import vn.kase.domain.v1.Shipper;
import vn.kase.domain.v1.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderDetailDto {
    private Long id;

    private User user;

    private Package shippingPackage;

    private String status;

    private Shipper shipper;
}