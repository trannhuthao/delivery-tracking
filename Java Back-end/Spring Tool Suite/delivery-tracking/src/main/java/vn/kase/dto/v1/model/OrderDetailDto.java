package vn.kase.dto.v1.model;

import lombok.*;

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

    private Long userAddressId;

    private String userAddress;

    private Long shippingPackageId;

    private String packageName;

    private byte packageImage;

    private Long weightId;

    private String weightRange;

    private Long boxSizeId;

    private String boxSize;

    private String packageDescription;

    private Long recipientId;

    private String recipientUsername;

    private String recipientFullname;

    private String recipientEmail;

    private String recipientPhoneNumber;

    private Long recipientAddressId;

    private String recipientAddress;

    private String status;

    private Long shipperId;
}