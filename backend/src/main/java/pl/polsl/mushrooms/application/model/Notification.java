package pl.polsl.mushrooms.application.model;

import pl.polsl.mushrooms.application.enums.NotificationType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"NOTIFICATIONS\"")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"NOTIFICATION_ID\"")
    private long id;

    @Column(name = "\"CONTENT\"", nullable = false)
    private String content;

    @Column(name = "\"TYPE\"")
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "\"USER_ID\"")
    private Mushroomer mushroomer;

    public Notification(String content, NotificationType type) {
        this.content = content;
        this.type = type;
        this.mushroomer = new Mushroomer();
    }

    public Notification(String content, NotificationType type, Mushroomer mushroomer) {
        this.content = content;
        this.type = type;
        this.mushroomer = mushroomer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Mushroomer getMushroomer() {
        return mushroomer;
    }

    public void setMushroomer(Mushroomer mushroomer) {
        this.mushroomer = mushroomer;
    }
}
