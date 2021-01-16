package vn.kase.dto.model;

import lombok.*;
import vn.kase.domain.OrderDetail;

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

    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}