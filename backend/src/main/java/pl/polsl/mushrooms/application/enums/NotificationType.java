package pl.polsl.mushrooms.application.enums;

/**
 * Created by chythe on 2017-07-02.
 */
public enum NotificationType {

    FRIEND_INVITATION("%s invite you to friends (%s)"),
    FRIEND_ACCEPTING("%s invite you to friends (%s)"),
    TRIP_ADDING("%s invite you to friends (%s)"),
    TRIP_ACCEPTING("%s invite you to friends (%s)"),
    MUSHROOM_FINDING("%s invite you to friends (%s)"),
    DISCOVERY_ADD_SCORE("%s add score to your discovery (%s)"),

    ;

    private String content;

    private NotificationType(final String content) {
        this.content = content;
    }

    public String getContent(final String username, final String dateTime) {
        return String.format(content, username, dateTime);
    }
}
