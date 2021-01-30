package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.user.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RoleDto {
    private Long id;

    private String roleName;

    private String description;

    private List<User> users = new ArrayList<User>();
}