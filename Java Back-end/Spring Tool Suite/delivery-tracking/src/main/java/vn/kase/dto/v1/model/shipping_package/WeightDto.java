package vn.kase.dto.v1.model.shipping_package;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WeightDto {
    private Long id;

    private Long packageId;

    private String packageName;

    private byte packageImage;

    private String weightRange;

    private Long boxSizeId;

    private String boxSize;

    private String description;

    private Long userId;

    private String userFullname;

    private String username;

    private String userEmail;

    private String userPhoneNumber;

    private Date userDateOfBirth;

    private String userAddress;

    private Long userRoleId;

    private String userRoleName;
}