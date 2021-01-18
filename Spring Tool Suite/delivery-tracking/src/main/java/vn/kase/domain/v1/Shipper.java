package vn.kase.domain.v1;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "orderDetailList" })
@ToString
@Entity
@Table(name = "shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "shipper", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}