package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.*;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripService {

    long handle(CreateTripCommand command);

    void handle(UpdateTripCommand command);

    void handle(DeleteTripCommand command);

    void handle(JoinTripCommand command);

    void handle(InviteToTripCommand command);
}
