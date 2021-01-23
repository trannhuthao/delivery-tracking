package vn.kase.domain.v1;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "user" })
@ToString
@Entity
@Table(name = "delivery_address")
public class DeliveryAddress extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public DeliveryAddress(Long id) {
        super(id);
    }
}