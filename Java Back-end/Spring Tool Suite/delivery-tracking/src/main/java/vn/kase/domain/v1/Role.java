package vn.kase.domain.v1;

import lombok.*;
import vn.kase.domain.v1.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<User>();

    public Role(Long id) {
        super(id);
    }
}