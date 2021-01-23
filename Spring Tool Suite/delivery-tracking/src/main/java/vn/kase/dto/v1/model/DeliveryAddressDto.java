package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DeliveryAddressDto {
    private Long id;

    private Long userId;

    private String username;

    private String userFullname;

    private String userEmail;

    private String userPhoneNumber;

    private String userAddress;
}