package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Trip")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private UUID id;
	private Date date;
	private Time time;
	private String place;

	@ManyToMany(mappedBy = "trips")
	private Set<Mushroomer> mushroomers;

	@OneToMany(mappedBy = "trip")
	private Set<Discovery> discoveries;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set<Mushroomer> getMushroomers() {
		return this.mushroomers;
	}

	public void setMushroomers(Set<Mushroomer> mushroomers) {
		throw new UnsupportedOperationException();
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
		if ( this.date != null ) {
			hashCode += this.date.hashCode();
		}
		if ( this.time != null ) {
			hashCode += this.time.hashCode();
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
				|| (this.id != null && this.id.equals(tripObject.id)));
			equals &= ((this.date == tripObject.date)
				|| (this.date != null && this.date.equals(tripObject.date)));
			equals &= ((this.time == tripObject.time)
				|| (this.time != null && this.time.equals(tripObject.time)));
			equals &= ((this.place == tripObject.place)
				|| (this.place != null && this.place.equals(tripObject.place)));
			equals &= this.mushroomers == tripObject.mushroomers;
			equals &= this.discoveries == tripObject.discoveries;
			return equals;
		}
		return false;
	}
}