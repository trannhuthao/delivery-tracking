package vn.kase.dto.model;

import lombok.*;
import vn.kase.domain.User;

import javax.persistence.*;

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