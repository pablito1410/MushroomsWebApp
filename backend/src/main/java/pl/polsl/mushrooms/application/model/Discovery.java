package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 16.04.2017.
 */

@Entity
@Table(name = "Discovery")
public class Discovery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "Id")
    private MushroomSpecie mushroomSpecie;

    private long userId;
    private long x;
    private long y;
    private long photoId;
    private LocalDateTime dateTime;

    private Discovery() { }

    public Discovery(Trip trip, long userId, long x, long y, long photoId, LocalDateTime dateTime) {
        this.trip = trip;
        this.userId = userId;
        this.x = x;
        this.y = y;
        this.photoId = photoId;
        this.dateTime = dateTime;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
