package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
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

    public UsersTripsId getPk() {
        return usersTripsId;
    }

    public void setPk(UsersTripsId pk) {
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
}
