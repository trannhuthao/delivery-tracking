package vn.kase.domain.v1.user;

import lombok.*;
import vn.kase.domain.v1.BaseEntity;

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
@Table(name = "address")
public class Address extends BaseEntity {
    private String address;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<User> users = new ArrayList<User>();

    public Address(Long id) {
        super(id);
    }
}