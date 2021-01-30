package vn.kase.dto.v1.model.user;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressDto {
    private Long id;

    private String address;

    private Long userId;

    private String userFullname;

    private String username;

    private String userPhoneNumber;

    private String userEmail;

    private Date userDateOfBirth;

    private Long userRoleId;

    private String userRoleName;
}