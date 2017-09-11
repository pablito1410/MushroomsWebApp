package pl.polsl.mushrooms.application.model;


import org.springframework.format.annotation.DateTimeFormat;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.enums.NotificationType;
import pl.polsl.mushrooms.application.enums.UserRole;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("MUSHROOMER")
public class Mushroomer extends User {

	@Column(name = "\"FIRST_NAME\"")
	private String firstName;

	@Column(name = "\"LAST_NAME\"")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "\"BIRTH_DATE\"")
	private Date birthDate;

	@Column(name = "\"GENDER\"")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "\"LEVEL\"")
	@Enumerated(EnumType.STRING)
	private MushroomerLevel level;

	@Column(name = "\"COUNTRY\"")
	private String country;

	@Column(name = "\"CITY\"")
	private String city;

	@Column(name = "\"PHOTO\"")
	private byte[] photo;

	@ManyToMany(targetEntity = Trip.class, mappedBy = "mushroomers",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Trip> trips;

	@OneToMany(mappedBy = "mushroomer")
	private Set<Score> scores;

	@OneToMany(mappedBy = "mushroomer")
	private Set<Discovery> discoveries;

	@OneToMany(mappedBy = "mushroomer")
	protected Set<Notification> notifications;

	@ManyToMany(targetEntity = Mushroomer.class,
			fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "\"USERS_USERS\"",
			joinColumns = {@JoinColumn(name = "\"USER_ID\"")},
			inverseJoinColumns = {@JoinColumn(name = "\"FRIEND_ID\"")})
	private Set<Mushroomer> users;

	@Enumerated(EnumType.STRING)
	@Column(name = "\"ROLE\"", nullable = false, insertable = false, updatable = false)
	protected UserRole role;

    @Override
    public UserRole getRole() {
        return role;
    }

	protected Mushroomer() {
        trips = new HashSet<>();
        scores = new HashSet<>();
        discoveries = new HashSet<>();
        users = new HashSet<>();
		notifications = new HashSet<>();
    }

	public Mushroomer(
			String username, String email, String password, String firstName, String lastName, Date birthDate, Gender gender, MushroomerLevel level) {
	    super(username, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.level = level;

        trips = new HashSet<>();
        scores = new HashSet<>();
        discoveries = new HashSet<>();
        users = new HashSet<>();
		notifications = new HashSet<>();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public MushroomerLevel getLevel() {
		return this.level;
	}

	public void setLevel(MushroomerLevel level) {
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

    public Set<Mushroomer> getFriends() {
        return users;
    }

    public void setFriends(Set<Mushroomer> friends) {
        this.users = friends;
    }

	public void addFriend(Mushroomer friend) { this.users.add(friend); }

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<Mushroomer> getUsers() {
		return users;
	}

	public void setUsers(Set<Mushroomer> users) {
		this.users = users;
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
			equals &= this.users == mushroomerObject.users;
			return equals;
		}
		return false;
	}

	public boolean removeFriend(Mushroomer friend) {
    	return this.users.remove(friend);
    }

    private Map<Long, Mushroomer> getFriendsMap() {
        return users.stream()
				.collect(Collectors.toMap(Mushroomer::getId, c -> c));
    }

	public boolean hasFriend(Mushroomer user) {
    	return getFriendsMap().containsKey(user.getId());
	}

	/**
	 *
	 * @param relatedId
	 * @param type
	 * @param userOfContent
	 */
	public Notification addNotification(
			final Long relatedId, NotificationType type, User userOfContent) {

    	final Notification notification = new Notification(relatedId, type, userOfContent);
    	notification.setMushroomer(this);
    	notifications.add(notification);
    	return notification;
	}


}