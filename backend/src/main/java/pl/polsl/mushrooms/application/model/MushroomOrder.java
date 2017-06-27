package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"MUSHROOMS_ORDERS\"")
public class MushroomOrder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"MUSH_ORDER_ID\"")
	private long id;

	@Column(name = "\"NAME\"", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "\"MUSH_CLASS_ID\"")
	private MushroomClass mushroomClass;

	@OneToMany(mappedBy = "order")
	private Set<MushroomFamily> families;

	protected MushroomOrder() {
		families = new HashSet<>();
	}

	public MushroomOrder(String name, MushroomClass mushroomClass) {
		this();
		this.name = name;
		this.mushroomClass = mushroomClass;
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

	public void setMushroomClass(MushroomClass mushroomClass) {
		this.mushroomClass = mushroomClass;
	}

	public MushroomClass getMushroomClass() {
		return this.mushroomClass;
	}

	public Set<MushroomFamily> getFamilies() {
		return families;
	}

	public void setFamilies(Set<MushroomFamily> families) {
		this.families = families;
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
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
				|| (this.id == mushroomOrderObject.id));
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