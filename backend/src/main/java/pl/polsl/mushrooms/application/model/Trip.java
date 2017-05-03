package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "TRIPS")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private UUID id;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "TIME", nullable = false)
	private Time time;

	@Column(name = "PLACE")
	private String place;

	@ManyToMany
	private Set<Mushroomer> mushroomers;

	@OneToMany(mappedBy = "trip")
	private Set<Discovery> discoveries;

	protected Trip() { }

	public Trip(Date date, Time time, String place) {
		this.date = date;
		this.time = time;
		this.place = place;

		mushroomers = new HashSet<>();
		discoveries = new HashSet<>();
	}

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
		this.mushroomers = mushroomers;
	}

	public void addMushroomer(final Mushroomer mushroomer)
	{
		if (mushroomers == null)
		{
			mushroomers = new LinkedHashSet<>();
		}
		mushroomers.add(mushroomer);
	}

	public Set<Discovery> getDiscoveries() {
		return discoveries;
	}

	public void setDiscoveries(Set<Discovery> discoveries) {
		this.discoveries = discoveries;
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