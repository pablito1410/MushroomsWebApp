package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MUSHROOMS_GENUSES")
public class MushroomGenus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "MUSH_GENUS_ID")
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "MUSH_FAMILY_ID")
	private MushroomFamily family;

	@OneToMany(mappedBy = "genus")
	private Set<MushroomSpecies> species;

	protected MushroomGenus() {
		species = new HashSet<>();
	}

	public MushroomGenus(String name, MushroomFamily family) {
		this();
		this.name = name;
		this.family = family;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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
		return species;
	}

	public void setSpecies(Set<MushroomSpecies> species) {
		this.species = species;
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
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
				|| (this.id == mushroomGenusObject.id));
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