package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.*;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripService {

    /**
     * Creates a new trip
     * @param command
     * @return Id of the created trip
     */
    long handle(CreateTripCommand command);

    /**
     * Updates the trip
     * @param command
     */
    void handle(UpdateTripCommand command);

    /**
     * Deletes the trip
     * @param command
     */
    void handle(DeleteTripCommand command);

    /**
     * Adds the user to the trip
     * @param command
     */
    void handle(JoinTripCommand command);

    /**
     * Invites the user to the trip
     * @param command
     */
    void handle(InviteToTripCommand command);
}
