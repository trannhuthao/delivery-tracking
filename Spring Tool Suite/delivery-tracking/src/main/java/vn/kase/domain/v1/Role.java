package vn.kase.domain.v1;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "users" })
@ToString
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<User>();

    public Role(Long id) {
        super(id);
    }
}