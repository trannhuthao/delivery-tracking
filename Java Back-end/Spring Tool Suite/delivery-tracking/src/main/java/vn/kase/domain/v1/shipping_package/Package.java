package vn.kase.domain.v1.shipping_package;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.kase.domain.v1.BaseEntity;
import vn.kase.domain.v1.OrderDetail;
import vn.kase.domain.v1.user.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "package")
public class Package extends BaseEntity {
	@Column(name = "package_name")
	private String packageName;

//	@Column(name = "image")
//	private byte image;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Weight weight;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private BoxSize boxSize;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private User user;

	public Package(Long id) {
		super(id);
	}
}