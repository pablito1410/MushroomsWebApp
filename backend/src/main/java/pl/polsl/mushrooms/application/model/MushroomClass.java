package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MushroomClass")
public class MushroomClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private UUID id;
	private String name;

	@OneToMany(mappedBy = "mushroomClass")
	private Set<MushroomOrder> orders;

	protected MushroomClass() { }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MushroomOrder> getOrders() {
		throw new UnsupportedOperationException();
	}

	public void setOrders(Set<MushroomOrder> orders) {
		throw new UnsupportedOperationException();
	}

	public int hashCode() {
		int hashCode = 0;
		if ( this.id != null ) {
			hashCode += this.id.hashCode();
		}
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
				|| (this.id != null && this.id.equals(mushroomClassObject.id)));
			equals &= ((this.name == mushroomClassObject.name)
				|| (this.name != null && this.name.equals(mushroomClassObject.name)));
			equals &= this.orders == mushroomClassObject.orders;
			return equals;
		}
		return false;
	}
}