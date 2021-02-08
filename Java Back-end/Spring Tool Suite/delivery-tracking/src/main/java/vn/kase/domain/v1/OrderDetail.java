package vn.kase.domain.v1;

import lombok.*;
import vn.kase.domain.v1.shipping_package.Package;
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
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Package shippingPackage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Shipper shipper;

    public OrderDetail(Long id) {
        super(id);
    }
}