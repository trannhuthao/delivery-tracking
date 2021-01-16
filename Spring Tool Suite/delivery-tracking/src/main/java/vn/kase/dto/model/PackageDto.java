package vn.kase.dto.model;

import lombok.*;
import vn.kase.domain.OrderDetail;
import vn.kase.domain.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PackageDto {
    private Long id;

    private String packageName;

    private byte image;

    private int weight;

    private String boxSize;

    private String description;

    private User user;

    private OrderDetail orderDetail;
}