package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.04.2017.
 */

@Entity
@Table(name = "MushroomSpecie")
public class MushroomSpecie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mushroomSpecie")
    private Set<Discovery> discoveries;

    public MushroomSpecie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
