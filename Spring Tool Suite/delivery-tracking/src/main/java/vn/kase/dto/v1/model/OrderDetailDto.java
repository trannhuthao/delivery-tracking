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

    private Long userId;

    private String username;

    private String userFullname;

    private String userEmail;

    private String userPhoneNumber;

    private String userAddress;

    private Long shippingPackageId;

    private String packageName;

    private byte packageImage;

    private int packageWeight;

    private String packageBoxSize;

    private String packageDescription;

    private String status;

    private Long shipperId;
}