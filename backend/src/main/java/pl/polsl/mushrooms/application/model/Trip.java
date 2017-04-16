package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.04.2017.
 */

@Entity
@Table(name="Trip")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;
    private LocalDateTime dateTime;
    private String place;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private Set<Discovery> discoveries;

    public Trip(LocalDateTime dateTime, String place) {
        this.dateTime = dateTime;
        this.place = place;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
