package pl.polsl.mushrooms.application.enums;


public enum NotificationType {

    FRIEND_INVITATION("%s would like to add you to your friends"),
    FRIEND_ACCEPTING("%s accept your invitation to friends"),
    TRIP_ADDING("%s invited you on a trip "),
    MUSHROOM_FINDING("%s found the mushroom on a trip in Krakow"),
    TRIP_ACCEPTING("%s accept your invitation on a trip"),
    DISCOVERY_ADD_SCORE("%s add score to your discovery"),

    ;

    private String content;

    NotificationType(final String content) {
        this.content = content;
    }

    public String getContent(final String username) {
        return String.format(content, username);
    }

}
