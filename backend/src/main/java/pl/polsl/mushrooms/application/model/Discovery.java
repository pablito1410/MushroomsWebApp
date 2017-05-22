package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DISCOVERIES")
public class Discovery extends Commentable{

	@Column(name = "COORDINATE_X")
	private String coordinateX;

	@Column(name = "COORDINATE_Y")
	private String coordinateY;

	@Column(name = "PHOTO")
	private byte[] photo;

	@Column(name = "DATE_TIME", nullable = false)
	private LocalDateTime dateTime;

	@ManyToOne(optional = false)
	private Trip trip;

	@ManyToOne
	private MushroomSpecies mushroomSpecies;

	@ManyToOne(optional = false)
	private Mushroomer mushroomer;

	@OneToMany(mappedBy = "discovery")
	private Set<Score> scores;

	@ManyToMany(mappedBy = "discovery")
	private Set<Tag> tags;

	@OneToMany(mappedBy = "target")
	private Set<Comment> comments;

	protected Discovery() {
		scores = new HashSet<>();
		tags = new HashSet<>();
		comments = new HashSet<>();
	}

	public Discovery(
			String coordinateX, String coordinateY, byte[] photo, LocalDateTime dateTime, Trip trip, MushroomSpecies mushroomSpecies, Mushroomer mushroomer) {
		this();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.photo = photo;
		this.dateTime = dateTime;
		this.trip = trip;
		this.mushroomSpecies = mushroomSpecies;
		this.mushroomer = mushroomer;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoordinateX() {
		return this.coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public MushroomSpecies getMushroomSpecies() {
		return this.mushroomSpecies;
	}

	public void setMushroomSpecies(MushroomSpecies mushroomSpecies) {
		this.mushroomSpecies = mushroomSpecies;
	}

	public Mushroomer getMushroomer() {
		return this.mushroomer;
	}

	public void setMushroomer(Mushroomer mushroomer) {
		this.mushroomer = mushroomer;
	}

	public Set<Score> getScores() {
		throw new UnsupportedOperationException();
	}

	public void setScores(Set<Score> scores) {
		throw new UnsupportedOperationException();
	}

	public Set<Tag> getTags() {
		throw new UnsupportedOperationException();
	}

	public void setTags(Set<Tag> tags) {
		throw new UnsupportedOperationException();
	}

	public Set<Comment> getComments() {
		throw new UnsupportedOperationException();
	}

	public void setComments(Set<Comment> comments) {
		throw new UnsupportedOperationException();
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
		if ( this.coordinateX != null ) {
			hashCode += this.coordinateX.hashCode();
		}
		if ( this.coordinateY != null ) {
			hashCode += this.coordinateY.hashCode();
		}
		if ( this.dateTime != null ) {
			hashCode += this.dateTime.hashCode();
		}
		if ( this.trip != null ) {
			hashCode += this.trip.hashCode();
		}
		if ( this.mushroomSpecies != null ) {
			hashCode += this.mushroomSpecies.hashCode();
		}
		if ( this.mushroomer != null ) {
			hashCode += this.mushroomer.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Discovery) {
			Discovery discoveryObject = (Discovery) object;
			boolean equals = true;
			equals &= ((this.id == discoveryObject.id)
				|| (this.id == discoveryObject.id));
			equals &= ((this.coordinateX == discoveryObject.coordinateX)
				|| (this.coordinateX != null && this.coordinateX.equals(discoveryObject.coordinateX)));
			equals &= ((this.coordinateY == discoveryObject.coordinateY)
				|| (this.coordinateY != null && this.coordinateY.equals(discoveryObject.coordinateY)));
			equals &= this.photo == discoveryObject.photo;
			equals &= ((this.dateTime == discoveryObject.dateTime)
				|| (this.dateTime != null && this.dateTime.equals(discoveryObject.dateTime)));
			equals &= ((this.trip == discoveryObject.trip)
				|| (this.trip != null && this.trip.equals(discoveryObject.trip)));
			equals &= ((this.mushroomSpecies == discoveryObject.mushroomSpecies)
				|| (this.mushroomSpecies != null && this.mushroomSpecies.equals(discoveryObject.mushroomSpecies)));
			equals &= ((this.mushroomer == discoveryObject.mushroomer)
				|| (this.mushroomer != null && this.mushroomer.equals(discoveryObject.mushroomer)));
			equals &= this.scores == discoveryObject.scores;
			equals &= this.tags == discoveryObject.tags;
			equals &= this.comments == discoveryObject.comments;
			return equals;
		}
		return false;
	}
}