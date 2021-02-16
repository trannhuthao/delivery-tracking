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

    private double total;

    public OrderDetail(Long id) {
        super(id);
    }

//    @Transient
//    public void checkout() {
////        if (this.shippingPackage.getWeight().getId() == 1 && this.shippingPackage.getBoxSize().getId() == 1) {
////            this.total += 15000.0;
////        }
////
////        if (this.shippingPackage.getWeight().getId() == 2) {
////            this.total += 15000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 3) {
////            this.total += 30000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 4) {
////            this.total += 45000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 5) {
////            this.total += 60000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 6) {
////            this.total += 75000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 7) {
////            this.total += 90000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 8) {
////            this.total += 105000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 9) {
////            this.total += 120000.0;
////        } else if (this.shippingPackage.getWeight().getId() == 10) {
////            this.total += 135000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 2) {
////            this.total += 150000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 3) {
////            this.total += 15000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 4) {
////            this.total += 30000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 5) {
////            this.total += 45000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 6) {
////            this.total += 60000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 7) {
////            this.total += 75000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 8) {
////            this.total += 90000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 9) {
////            this.total += 105000.0;
////        } else if (this.shippingPackage.getBoxSize().getId() == 10) {
////            this.total += 120000.0;
////        }
//
//        this.total = 5;
//    }
}