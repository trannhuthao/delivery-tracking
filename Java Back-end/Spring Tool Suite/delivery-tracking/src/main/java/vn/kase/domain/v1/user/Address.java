package vn.kase.domain.v1.user;

import lombok.*;
import vn.kase.domain.v1.BaseEntity;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public Address(Long id) {
        super(id);
    }
}