package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MushroomGenus")
public class MushroomGenus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private UUID id;
	private String name;

	@ManyToOne
	private MushroomFamily family;

	@OneToMany(mappedBy = "genus")
	private Set<MushroomSpecies> species;

	protected MushroomGenus() { }

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

	public MushroomFamily getFamily() {
		return this.family;
	}

	public void setFamily(MushroomFamily family) {
		this.family = family;
	}

	public Set<MushroomSpecies> getSpecies() {
		throw new UnsupportedOperationException();
	}

	public void setSpecies(Set<MushroomSpecies> species) {
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
		if ( this.family != null ) {
			hashCode += this.family.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof MushroomGenus) {
			MushroomGenus mushroomGenusObject = (MushroomGenus) object;
			boolean equals = true;
			equals &= ((this.id == mushroomGenusObject.id)
				|| (this.id != null && this.id.equals(mushroomGenusObject.id)));
			equals &= ((this.name == mushroomGenusObject.name)
				|| (this.name != null && this.name.equals(mushroomGenusObject.name)));
			equals &= ((this.family == mushroomGenusObject.family)
				|| (this.family != null && this.family.equals(mushroomGenusObject.family)));
			equals &= this.species == mushroomGenusObject.species;
			return equals;
		}
		return false;
	}
}