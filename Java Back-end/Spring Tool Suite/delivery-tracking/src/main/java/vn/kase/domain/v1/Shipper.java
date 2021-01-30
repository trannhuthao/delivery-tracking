package vn.kase.domain.v1;

import lombok.*;

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
@Table(name = "shipper")
public class Shipper extends BaseEntity {
    @OneToMany(mappedBy = "shipper", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

    private String fullName;

    public Shipper(Long id) {
        super(id);
    }
}