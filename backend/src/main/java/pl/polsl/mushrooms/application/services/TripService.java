package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.CreateCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteCommand;
import pl.polsl.mushrooms.application.commands.trip.GetCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateCommand;
import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripService {

    void handle(CreateCommand command);

    Trip handle(GetCommand command);

    void handle(UpdateCommand command);

    void handle(DeleteCommand command);
}
