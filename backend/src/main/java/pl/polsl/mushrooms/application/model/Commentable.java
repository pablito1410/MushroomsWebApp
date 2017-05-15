package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 22.04.2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Commentable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected UUID id;

    public abstract UUID getId();

    public abstract void setId(UUID id);
}
