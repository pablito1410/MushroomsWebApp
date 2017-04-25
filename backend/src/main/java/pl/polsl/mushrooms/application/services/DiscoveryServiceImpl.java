package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteCommand;
import pl.polsl.mushrooms.application.commands.discovery.GetCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.MushroomSpeciesDao;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DiscoveryServiceImpl implements DiscoveryService {


    private final DiscoveryDao discoveryDao;
    private final TripDao tripRepository;
    private final MushroomSpeciesDao mushroomSpeciesDao;

    public DiscoveryServiceImpl(
            final DiscoveryDao discoveryDao,
            final TripDao tripRepository,
            final MushroomSpeciesDao mushroomSpeciesDao)
    {
        this.discoveryDao = discoveryDao;
        this.tripRepository = tripRepository;
        this.mushroomSpeciesDao = mushroomSpeciesDao;
    }
    @Override
    public void handle(CreateCommand command) {

        final Trip trip = tripRepository.findTrip(command.getTripId());
//        final MushroomSpecies mushroomSpecies =

        final Discovery discovery = new Discovery(
            command.getCoordinateX(),
                command.getCoordinateY(),
                command.getPhoto(),
                command.getDate(),
                command.getTime(),
                trip,
                null, // TODO
                null// TODO
        );

//        discoveryDao.s
    }

    @Override
    public Discovery handle(GetCommand command) {
        return null;
    }

    @Override
    public void handle(UpdateCommand command) {

    }

    @Override
    public void handle(DeleteCommand command) {

    }
}
