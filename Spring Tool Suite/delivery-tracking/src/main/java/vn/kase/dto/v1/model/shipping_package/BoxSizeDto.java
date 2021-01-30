package vn.kase.dto.v1.model.shipping_package;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BoxSizeDto {
    private Long id;

    private Long shippingPackageId;

    private String shippingPackageName;

    private byte shippingPackageImage;

    private Long weightId;

    private String weightRange;

    private String boxSize;

    private String shippingPackageDescription;

    private Long userId;

    private String userFullname;

    private String username;

    private String userEmail;

    private String userPhoneNumber;

    private Date userDateOfBirth;

    private String userAddress;

    private Long roleId;

    private String roleName;

    private Long orderDetailId;

    private String orderDetailStatus;

    private Long shipperId;
}