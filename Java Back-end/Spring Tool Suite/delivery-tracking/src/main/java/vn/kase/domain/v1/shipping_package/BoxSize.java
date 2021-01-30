package vn.kase.domain.v1.shipping_package;

import lombok.*;
import vn.kase.domain.v1.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "box_size")
public class BoxSize extends BaseEntity {
    private String boxSize;

    public BoxSize(Long id) {
        super(id);
    }
}