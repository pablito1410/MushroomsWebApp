package pl.polsl.mushrooms.application.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pawel_zaqkxkn on 16.04.2017.
 */

@Entity
@Table(name="TripParticipant")
public class TripParticipant implements Serializable {

    @Id
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "Id")
    private Trip trip;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private User user;

    public TripParticipant(Trip trip, User user) {
        this.trip = trip;
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
