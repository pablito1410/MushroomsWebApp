package pl.polsl.mushrooms.application.model;

import pl.polsl.mushrooms.application.enums.NotificationType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Column(name = "\"RELATED_ID\"")
    private Long relatedId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "\"USER_ID\"")
    private Mushroomer mushroomer;

    @Column(name = "\"DATE_TIME\"", nullable = false)
    private LocalDateTime dateTime;

    /**
     * Is necessary to create content
     */
    @Transient
    private User userOfContent;

    protected Notification() { }

    /**
     *
     * @param type
     * @param userOfContent
     */
    public Notification(final Long relatedId, NotificationType type, final User userOfContent) {
        Objects.requireNonNull(relatedId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(userOfContent);
        this.type = type;
        this.userOfContent = userOfContent;
        this.relatedId = relatedId;
    }

    @PrePersist
    private void setContentAndDateTime() {
        this.dateTime = LocalDateTime.now();
        this.content = type.getContent(userOfContent.getUsername()); // TODO format daty
    }

    long getId() {
        return id;
    }

    void setId(final long id) {
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

    public Long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }

    public Mushroomer getMushroomer() {
        return mushroomer;
    }

    public void setMushroomer(Mushroomer mushroomer) {
        this.mushroomer = mushroomer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUserOfContent() {
        return userOfContent;
    }

    public void setUserOfContent(User userOfContent) {
        this.userOfContent = userOfContent;
    }
}
