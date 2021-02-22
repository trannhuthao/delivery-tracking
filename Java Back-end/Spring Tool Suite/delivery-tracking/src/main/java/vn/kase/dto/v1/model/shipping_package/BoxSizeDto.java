package vn.kase.dto.v1.model.shipping_package;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BoxSizeDto {
    private Long id;

    private String boxSize;
}