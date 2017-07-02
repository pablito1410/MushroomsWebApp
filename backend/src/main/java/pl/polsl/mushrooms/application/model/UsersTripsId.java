package pl.polsl.mushrooms.application.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
@Embeddable
public class UsersTripsId implements Serializable {

    @ManyToOne(optional =  false, targetEntity = User.class)
    @JoinColumn(name = "\"USER_ID\"")
    private User user;

    @ManyToOne(optional = false, targetEntity = Trip.class)
    @JoinColumn(name = "\"TRIP_ID\"")
    private Trip trip;

    protected UsersTripsId() { }

    public UsersTripsId(User user, Trip trip) {
        this.trip = trip;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getUserId() { return user.getId(); }

    public void setUserId(final Long id) { this.user.setId(id); }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Long getTripId() { return trip.getId(); }

    public void setTripId(final Long id) { this.trip.setId(id); }
}
