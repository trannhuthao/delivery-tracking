package vn.kase.dto.v1.model.shipping_package;

import lombok.*;
import vn.kase.domain.v1.shipping_package.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PackageDto {
    private Long id;

    private String packageName;

//    private byte image;

    private Long weightId;

    private String weightRange;

    private Long boxSizeId;

    private String boxSize;

    private String description;

    private Status status;

    private Long userId;

    private String username;

    private String userFullname;

    private String userEmail;

    private String userPhoneNumber;

    private Long userAddressId;

    private String userAddress;
}