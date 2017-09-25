package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"DISCOVERIES\"")
public class Discovery  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"DISCOVERY_ID\"")
	protected Long id;

	@Column(name = "\"COORDINATE_X\"")
	private double coordinateX;

	@Column(name = "\"COORDINATE_Y\"")
	private double coordinateY;

	@Column(name = "\"PHOTO\"")
	private byte[] photo;

	@Column(name = "\"DATE_TIME\"", nullable = false)
	private LocalDateTime dateTime;

	@Column(name = "\"IS_PUBLIC\"")
	private Boolean isPublic;

	@ManyToOne(optional = false)
	@JoinColumn(name = "\"TRIP_ID\"")
	private Trip trip;

	@ManyToOne(optional = false)
	@JoinColumn(name = "\"MUSH_SPECIES_ID\"")
	private MushroomSpecies mushroomsSpecies;

	@ManyToOne(optional = false)
	@JoinColumn(name = "\"USER_ID\"")
	private Mushroomer mushroomer;

	@OneToMany(mappedBy = "discovery")
	private Set<Score> scores;

	@ManyToMany(mappedBy = "discovery")
	private Set<Tag> tags;

	@OneToMany(mappedBy = "discovery")
	private Set<Comment> comments;

	protected Discovery() {
		scores = new HashSet<>();
		tags = new HashSet<>();
		comments = new HashSet<>();
	}

	public Discovery(
			double coordinateX,
			double coordinateY,
			byte[] photo,
			LocalDateTime dateTime,
			Trip trip,
			MushroomSpecies mushroomSpecies,
			Mushroomer mushroomer,
			final boolean isPublic) {
		this();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.photo = photo;
		this.dateTime = dateTime;
		this.trip = trip;
		this.mushroomsSpecies = mushroomSpecies;
		this.mushroomer = mushroomer;
		this.isPublic = Boolean.valueOf(isPublic);
	}

	public Long getId() {
		return id;
	}

	public double getCoordinateX() {
		return this.coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
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

	public MushroomSpecies getmushroomspecies() {
		return this.mushroomsSpecies;
	}

	public Long getMushroomSpeciesId() {
		return mushroomsSpecies == null ? null : mushroomsSpecies.getId();
	}

	public void setMushroomSpecies(MushroomSpecies mushroomSpecies) {
		this.mushroomsSpecies = mushroomSpecies;
	}

	public Mushroomer getMushroomer() {
		return this.mushroomer;
	}

	public void setMushroomer(Mushroomer mushroomer) {
		this.mushroomer = mushroomer;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Boolean isPublic() { return isPublic; }

	public void setPublic(boolean aPublic) { isPublic = aPublic; }

	public double scoresAverage() {
		return scores.stream().mapToLong(s -> s.getValue()).average().orElse(Double.valueOf(0));
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
//		if (this.coordinateX != null) {
//			hashCode += this.coordinateX.hashCode();
//		}
//		if (this.coordinateY != null) {
//			hashCode += this.coordinateY.hashCode();
//		}
		if (this.dateTime != null) {
			hashCode += this.dateTime.hashCode();
		}
		if (this.trip != null) {
			hashCode += this.trip.hashCode();
		}
		if (this.mushroomsSpecies != null) {
			hashCode += this.mushroomsSpecies.hashCode();
		}
		if (this.mushroomer != null) {
			hashCode += this.mushroomer.hashCode();
		}
		if (hashCode == 0) {
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
//			equals &= ((this.id == discoveryObject.id)
//					|| (this.id == discoveryObject.id));
			equals &= (this.coordinateX == discoveryObject.coordinateX);
			equals &= (this.coordinateY == discoveryObject.coordinateY);
			equals &= this.photo == discoveryObject.photo;
			equals &= ((this.dateTime == discoveryObject.dateTime)
					|| (this.dateTime != null && this.dateTime.equals(discoveryObject.dateTime)));
			equals &= ((this.trip == discoveryObject.trip)
					|| (this.trip != null && this.trip.equals(discoveryObject.trip)));
			equals &= ((this.mushroomsSpecies == discoveryObject.mushroomsSpecies)
					|| (this.mushroomsSpecies != null && this.mushroomsSpecies.equals(discoveryObject.mushroomsSpecies)));
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