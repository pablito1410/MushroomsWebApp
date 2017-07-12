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
    private LocalDateTime dateTime; // TODO

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
        this.content = type.getContent(userOfContent.getUsername(), dateTime.toString()); // TODO format daty
    }

//    public static class NotificationBuilder {
//
//        private String content;
//        private NotificationType type;
//        private Mushroomer mushroomer;
//        private LocalDateTime dateTime;
//
//        private NotificationBuilder() { }
//
//        public static NotificationBuilder type(final NotificationType type) {
//            verifyNotNull(type);
//            final NotificationBuilder builder = new NotificationBuilder();
//            builder.type = type;
//            return builder;
//        }
//
//        public NotificationBuilder dateTime(final LocalDateTime dateTime) {
//            this.dateTime = dateTime;
//            return this;
//        }
//
//
//        public NotificationBuilder mushroomer(final Mushroomer mushroomer) {
//            this.mushroomer = mushroomer;
//            return this;
//        }
//
//        public Notification build() {
//            return new Notification(type, mushroomer, dateTime);
//        }
//    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    private void setDateTime(final LocalDateTime localDateTime) {
        this.dateTime = localDateTime;
    }
}
