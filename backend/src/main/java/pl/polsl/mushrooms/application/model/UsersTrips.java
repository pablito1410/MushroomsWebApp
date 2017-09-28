package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "\"USERS_TRIPS\"")
@AssociationOverrides({
        @AssociationOverride(name = "usersTripsId.user",
                joinColumns = @JoinColumn(name = "\"USER_ID\"")),
        @AssociationOverride(name = "usersTripsId.trip",
                joinColumns = @JoinColumn(name = "\"TRIP_ID\"")) })
public class UsersTrips implements Serializable {

    @EmbeddedId
    private UsersTripsId usersTripsId;

    @Column(name = "\"DATE_TIME\"")
    private LocalDateTime dateTime;

    protected UsersTrips() { }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public UsersTripsId getUsersTripsId() {
        return usersTripsId;
    }

    public void setUsersTripsId(UsersTripsId pk) {
        this.usersTripsId = pk;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setUsersTripsIdUserId(final Long userId) {
        usersTripsId.setUserId(userId);
    }

    public void setUsersTripsIdTripId(final Long tripId) {
        usersTripsId.setTripId(tripId);
    }

    public Long getUserId() {
        return usersTripsId.getUserId();
    }

    public Long getTripId() {
        return usersTripsId.getTripId();
    }
}
