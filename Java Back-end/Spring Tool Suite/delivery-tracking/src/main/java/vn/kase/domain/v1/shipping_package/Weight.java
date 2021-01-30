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
@Table(name = "weight")
public class Weight extends BaseEntity {
    private String weightRange;

    public Weight(Long id) {
        super(id);
    }
}