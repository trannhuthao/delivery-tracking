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

    private User user;
}