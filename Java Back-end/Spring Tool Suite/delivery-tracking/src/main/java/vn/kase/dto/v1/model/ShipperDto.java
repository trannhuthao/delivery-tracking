package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.OrderDetail;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ShipperDto {
    private Long id;

    private String fullName;

    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}