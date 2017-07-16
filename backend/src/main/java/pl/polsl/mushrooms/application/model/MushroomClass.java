package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"MUSHROOMS_CLASSES\"")
public class MushroomClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"MUSH_CLASS_ID\"")
	private Long id;

	@Column(name = "\"NAME\"", nullable = false)
	private String name;

	@OneToMany(mappedBy = "mushroomClass")
	private Set<MushroomOrder> orders;

	protected MushroomClass() {
		orders = new HashSet<>();
	}

	public MushroomClass(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MushroomOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<MushroomOrder> orders) {
		this.orders = orders;
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
		if ( this.name != null ) {
			hashCode += this.name.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof MushroomClass) {
			MushroomClass mushroomClassObject = (MushroomClass) object;
			boolean equals = true;
			equals &= ((this.id == mushroomClassObject.id)
				|| (this.id == mushroomClassObject.id));
			equals &= ((this.name == mushroomClassObject.name)
				|| (this.name != null && this.name.equals(mushroomClassObject.name)));
			equals &= this.orders == mushroomClassObject.orders;
			return equals;
		}
		return false;
	}
}