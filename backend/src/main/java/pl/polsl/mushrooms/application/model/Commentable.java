package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pawel_zaqkxkn on 22.04.2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Commentable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    protected long id;

    public abstract long getId();

    public abstract void setId(long id);
}
