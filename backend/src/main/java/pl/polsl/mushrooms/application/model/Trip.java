package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"TRIPS\"")
public class Trip implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"TRIP_ID\"")
	private Long id;

	@Column(name = "\"DATE_TIME\"", nullable = false)
	private LocalDateTime dateTime;

	@Column(name = "\"PLACE\"")
	private String place;

	@Column(name = "\"COORDINATE_X\"")
	private Double coordinateX;

	@Column(name = "\"COORDINATE_Y\"")
	private Double coordinateY;

	@Column(name = "\"RADIUS\"")
	private Double radius;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "\"USERS_TRIPS\"",
			joinColumns = {@JoinColumn(name = "\"TRIP_ID\"")},
			inverseJoinColumns = {@JoinColumn(name = "\"USER_ID\"")})
	private Set<Mushroomer> mushroomers;

	@OneToMany(mappedBy = "trip")
	private Set<Discovery> discoveries;

	protected Trip() {
		mushroomers = new HashSet<>();
		discoveries = new HashSet<>();
	}

	public Trip(LocalDateTime dateTime, String place, Double coordinateX, Double coordinateY, Double radius) {
		this.dateTime = dateTime;
		this.place = place;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.radius = radius;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set<Mushroomer> getMushroomers() {
		return this.mushroomers;
	}

	public Set<Long> getMushroomersIds() {
		final Set<Long> ids = new HashSet<>();
		mushroomers.forEach(m -> ids.add(m.getId()));
		return ids;
	}

	public void setMushroomers(Set<Mushroomer> mushroomers) {
		this.mushroomers = mushroomers;
	}

	public void addMushroomer(final Mushroomer mushroomer) { mushroomers.add(mushroomer); }

	public Set<Discovery> getDiscoveries() { return discoveries; }

	public void setDiscoveries(Set<Discovery> discoveries) {
		this.discoveries = discoveries;
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int hashCode() {
		int hashCode = 0;
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
		if ( this.dateTime != null ) {
			hashCode += this.dateTime.hashCode();
		}
		if ( this.place != null ) {
			hashCode += this.place.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Trip) {
			Trip tripObject = (Trip) object;
			boolean equals = true;
			equals &= ((this.id == tripObject.id)
				|| (this.id == tripObject.id));
			equals &= ((this.dateTime == tripObject.dateTime)
				|| (this.dateTime != null && this.dateTime.equals(tripObject.dateTime)));
			equals &= ((this.place == tripObject.place)
				|| (this.place != null && this.place.equals(tripObject.place)));
			equals &= this.mushroomers == tripObject.mushroomers;
			equals &= this.discoveries == tripObject.discoveries;
			return equals;
		}
		return false;
	}

}