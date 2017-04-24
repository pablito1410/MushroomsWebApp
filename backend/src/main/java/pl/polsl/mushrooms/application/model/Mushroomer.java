package pl.polsl.mushrooms.application.model;


import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.UserRole;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Mushroomer")
public class Mushroomer extends User {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Gender gender;
	private int level;

	@ManyToMany
	private Set<Trip> trips;

	@OneToMany(mappedBy = "mushroomer")
	private Set<Score> scores;

	@OneToMany(mappedBy = "mushroomer")
	private Set<Discovery> discoveries;

	protected Mushroomer() { }

	public Mushroomer(String username, String email, String password, UserRole role) {
		super(username, email, password, role);
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Set<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public Set<Discovery> getDiscoveries() {
		return discoveries;
	}

	public void setDiscoveries(Set<Discovery> discoveries) {
		this.discoveries = discoveries;
	}

	public int hashCode() {
		int hashCode = 0;
		if ( this.firstName != null ) {
			hashCode += this.firstName.hashCode();
		}
		if ( this.lastName != null ) {
			hashCode += this.lastName.hashCode();
		}
		if ( this.birthDate != null ) {
			hashCode += this.birthDate.hashCode();
		}
		if ( this.gender != null ) {
			hashCode += this.gender.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Mushroomer) {
			Mushroomer mushroomerObject = (Mushroomer) object;
			boolean equals = true;
			equals &= ((this.firstName == mushroomerObject.firstName)
				|| (this.firstName != null && this.firstName.equals(mushroomerObject.firstName)));
			equals &= ((this.lastName == mushroomerObject.lastName)
				|| (this.lastName != null && this.lastName.equals(mushroomerObject.lastName)));
			equals &= ((this.birthDate == mushroomerObject.birthDate)
				|| (this.birthDate != null && this.birthDate.equals(mushroomerObject.birthDate)));
			equals &= ((this.gender == mushroomerObject.gender)
				|| (this.gender != null && this.gender.equals(mushroomerObject.gender)));
			equals &= this.level == mushroomerObject.level;
			equals &= this.trips == mushroomerObject.trips;
			equals &= this.scores == mushroomerObject.scores;
			equals &= this.discoveries == mushroomerObject.discoveries;
			return equals;
		}
		return false;
	}
}