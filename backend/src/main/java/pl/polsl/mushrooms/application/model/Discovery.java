package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "DISCOVERIES")
public class Discovery extends Commentable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DISCOVERY_ID")
	protected UUID id;

	@Column(name = "COORDINATE_X")
	private String coordinateX;

	@Column(name = "COORDINATE_Y")
	private String coordinateY;

	@Column(name = "PHOTO")
	private byte[] photo;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "TIME", nullable = false)
	private Time time;

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

	@OneToMany
	private Set<Comment> comments;

	protected Discovery() { }

	public Discovery(
			String coordinateX, String coordinateY, byte[] photo, Date date, Time time, Trip trip, MushroomSpecies mushroomSpecies, Mushroomer mushroomer) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.photo = photo;
		this.date = date;
		this.time = time;
		this.trip = trip;
		this.mushroomSpecies = mushroomSpecies;
		this.mushroomer = mushroomer;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
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
		if ( this.id != null ) {
			hashCode += this.id.hashCode();
		}
		if ( this.coordinateX != null ) {
			hashCode += this.coordinateX.hashCode();
		}
		if ( this.coordinateY != null ) {
			hashCode += this.coordinateY.hashCode();
		}
		if ( this.date != null ) {
			hashCode += this.date.hashCode();
		}
		if ( this.time != null ) {
			hashCode += this.time.hashCode();
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
				|| (this.id != null && this.id.equals(discoveryObject.id)));
			equals &= ((this.coordinateX == discoveryObject.coordinateX)
				|| (this.coordinateX != null && this.coordinateX.equals(discoveryObject.coordinateX)));
			equals &= ((this.coordinateY == discoveryObject.coordinateY)
				|| (this.coordinateY != null && this.coordinateY.equals(discoveryObject.coordinateY)));
			equals &= this.photo == discoveryObject.photo;
			equals &= ((this.date == discoveryObject.date)
				|| (this.date != null && this.date.equals(discoveryObject.date)));
			equals &= ((this.time == discoveryObject.time)
				|| (this.time != null && this.time.equals(discoveryObject.time)));
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