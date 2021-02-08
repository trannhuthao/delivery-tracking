package vn.kase.domain.v1;

import lombok.*;
import vn.kase.domain.v1.shipping_package.Package;
import vn.kase.domain.v1.user.Address;
import vn.kase.domain.v1.user.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "order_detail")
public class OrderDetail extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    private Package shippingPackage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Shipper shipper;

    @OneToOne(fetch = FetchType.LAZY)
    private User recipient;

    public OrderDetail(Long id) {
        super(id);
    }
}