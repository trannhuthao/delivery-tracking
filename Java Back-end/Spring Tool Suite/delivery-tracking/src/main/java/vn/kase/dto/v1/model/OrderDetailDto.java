package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.shipping_package.Status;

import java.util.Date;

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

    private String userFullName;

    private String userEmail;

    private String userPhoneNumber;

    private Date userDateOfBirth;

    private Long userAddressId;

    private String userAddress;

    private Long userRoleId;

    private String userRoleDescription;

    private Long shippingPackageId;

    private String packageName;

//    private byte packageImage;

    private Long weightId;

    private String weightRange;

    private Long boxSizeId;

    private String boxSize;

    private String packageDescription;

    private Status status;

    private Long packageOwnerId;

    private String packageOwnerUsername;

    private String packageOwnerFullname;

    private String packageOwnerEmail;

    private String packageOwnerPhoneNumber;

    private Date packageOwnerDateOfBirth;

    private Long packageOwnerAddressId;

    private String packageOwnerAddress;

    private Long packageOwnerRoleId;

    private String packageOwnerRoleDescription;

    private Long shipperId;

    private String shipperFullName;

    private Long recipientId;

    private String recipientUsername;

    private String recipientFullName;

    private String recipientEmail;

    private String recipientPhoneNumber;

    private Date recipientDateOfBirth;

    private Long recipientAddressId;

    private String recipientAddress;

    private Long recipientRoleId;

    private String recipientRoleDescription;

    private double total;
}