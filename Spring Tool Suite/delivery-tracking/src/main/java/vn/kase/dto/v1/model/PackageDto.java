package vn.kase.dto.v1.model;

import lombok.*;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.User;

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

    private Long userId;

    private String username;

    private String userFullname;

    private String userEmail;

    private String userPhoneNumber;

    private String userAddress;

    private Long orderDetailId;

    private String orderDetailStatus;

    private Long shipperId;
}