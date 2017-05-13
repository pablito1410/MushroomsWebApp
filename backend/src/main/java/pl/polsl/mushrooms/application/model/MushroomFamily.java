package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MUSHROOMS_FAMILIES")
public class MushroomFamily implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MUSH_FAMILY_ID")
	private UUID id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(optional = false)
	private MushroomOrder order;

	@OneToMany(mappedBy = "family")
	private Set<MushroomGenus> genuses;

	protected MushroomFamily() { }

	public MushroomFamily(String name, MushroomOrder order) {
		this.name = name;
		this.order = order;
	}

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

	public MushroomOrder getOrder() {
		return this.order;
	}

	public void setOrder(MushroomOrder order) {
		this.order = order;
	}

	public Set<MushroomGenus> getGenuses() {
		throw new UnsupportedOperationException();
	}

	public void setGenuses(Set<MushroomGenus> genuses) {
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
		if ( this.order != null ) {
			hashCode += this.order.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof MushroomFamily) {
			MushroomFamily mushroomFamilyObject = (MushroomFamily) object;
			boolean equals = true;
			equals &= ((this.id == mushroomFamilyObject.id)
				|| (this.id != null && this.id.equals(mushroomFamilyObject.id)));
			equals &= ((this.name == mushroomFamilyObject.name)
				|| (this.name != null && this.name.equals(mushroomFamilyObject.name)));
			equals &= ((this.order == mushroomFamilyObject.order)
				|| (this.order != null && this.order.equals(mushroomFamilyObject.order)));
			equals &= this.genuses == mushroomFamilyObject.genuses;
			return equals;
		}
		return false;
	}
}