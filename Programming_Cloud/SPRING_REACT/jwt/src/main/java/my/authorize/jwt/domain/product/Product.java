package my.authorize.jwt.domain.product;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String brand;

	public Product() {
	}

	public Product(String type, String brand) {
		this.brand = brand;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String describe) {
		this.brand = describe;
	}
}
