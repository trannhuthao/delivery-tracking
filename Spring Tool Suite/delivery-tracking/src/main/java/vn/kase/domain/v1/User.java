package vn.kase.domain.v1;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "roles", "orderDetailList", "shippingPackages", "deliveryAddress" })
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<Role>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Package> shippingPackages = new ArrayList<Package>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private DeliveryAddress deliveryAddress;
}