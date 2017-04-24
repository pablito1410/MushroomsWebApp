package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MushroomOrder")
public class MushroomOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private UUID id;
	private String name;

	@ManyToOne
	private MushroomClass mushroomClass;

	@OneToMany(mappedBy = "order")
	private Set<MushroomFamily> families;

	protected MushroomOrder() { }

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

	public void setMushroomClass(MushroomClass mushroomClass) {
		this.mushroomClass = mushroomClass;
	}

	public MushroomClass getMushroomClass() {
		return this.mushroomClass;
	}

	public Set<MushroomFamily> getFamilies() {
		throw new UnsupportedOperationException();
	}

	public void setFamilies(Set<MushroomFamily> families) {
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
		if ( this.mushroomClass != null ) {
			hashCode += this.mushroomClass.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof MushroomOrder) {
			MushroomOrder mushroomOrderObject = (MushroomOrder) object;
			boolean equals = true;
			equals &= ((this.id == mushroomOrderObject.id)
				|| (this.id != null && this.id.equals(mushroomOrderObject.id)));
			equals &= ((this.name == mushroomOrderObject.name)
				|| (this.name != null && this.name.equals(mushroomOrderObject.name)));
			equals &= ((this.mushroomClass == mushroomOrderObject.mushroomClass)
				|| (this.mushroomClass != null && this.mushroomClass.equals(mushroomOrderObject.mushroomClass)));
			equals &= this.families == mushroomOrderObject.families;
			return equals;
		}
		return false;
	}

}