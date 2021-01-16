package vn.kase.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "package")
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "package_name")
	private String packageName;

	@Column(name = "image")
	private byte image;

	@Column(name = "weight")
	private int weight;

	@Column(name = "box_size")
	private String boxSize;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private User user;

	@OneToOne(mappedBy = "shippingPackage", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private OrderDetail orderDetail;
}