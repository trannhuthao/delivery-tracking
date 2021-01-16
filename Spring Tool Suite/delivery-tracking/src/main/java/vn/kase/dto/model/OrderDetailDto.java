package vn.kase.dto.model;

import lombok.*;
import vn.kase.domain.Package;
import vn.kase.domain.Shipper;
import vn.kase.domain.User;

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