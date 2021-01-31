package vn.kase.dto.v1.model.user;

import lombok.*;
import vn.kase.domain.v1.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressDto {
    private Long id;

    private String address;

    private List<User> users = new ArrayList<User>();
}