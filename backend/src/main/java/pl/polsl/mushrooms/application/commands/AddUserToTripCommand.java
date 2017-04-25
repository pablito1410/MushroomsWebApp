package pl.polsl.mushrooms.application.commands;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class AddUserToTripCommand implements VoidCommand {

    private UUID tripId;
    private UUID userId;

    protected AddUserToTripCommand() { }

    public UUID getTripId() {
        return tripId;
    }

    public UUID getUserId() {
        return userId;
    }
}
