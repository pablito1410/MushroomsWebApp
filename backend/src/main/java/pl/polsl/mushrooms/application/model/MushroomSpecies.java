package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MUSHROOMS_SPECIES")
public class MushroomSpecies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private UUID id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EXAMPLE_PHOTO")
	private byte[] examplePhoto;

	@ManyToOne(optional = false)
	private MushroomGenus genus;

	@OneToMany(mappedBy = "mushroomSpecies")
	private Set<Discovery> discoveries;

	protected MushroomSpecies() { }

	public MushroomSpecies(String name, byte[] examplePhoto, MushroomGenus genus) {
		this.name = name;
		this.examplePhoto = examplePhoto;
		this.genus = genus;
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

	public MushroomGenus getGenus() {
		return this.genus;
	}

	public void setGenus(MushroomGenus genus) {
		this.genus = genus;
	}

	public byte[] getExamplePhoto() {
		return this.examplePhoto;
	}

	public void setExamplePhoto(byte[] examplePhoto) {
		this.examplePhoto = examplePhoto;
	}

	public Set<Discovery> getDiscoveries() {
		throw new UnsupportedOperationException();
	}

	public void setDiscoveries(Set<Discovery> discoveries) {
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
		if ( this.genus != null ) {
			hashCode += this.genus.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof MushroomSpecies) {
			MushroomSpecies mushroomSpeciesObject = (MushroomSpecies) object;
			boolean equals = true;
			equals &= ((this.id == mushroomSpeciesObject.id)
				|| (this.id != null && this.id.equals(mushroomSpeciesObject.id)));
			equals &= ((this.name == mushroomSpeciesObject.name)
				|| (this.name != null && this.name.equals(mushroomSpeciesObject.name)));
			equals &= this.examplePhoto == mushroomSpeciesObject.examplePhoto;
			equals &= ((this.genus == mushroomSpeciesObject.genus)
				|| (this.genus != null && this.genus.equals(mushroomSpeciesObject.genus)));
			equals &= this.discoveries == mushroomSpeciesObject.discoveries;
			return equals;
		}
		return false;
	}
}