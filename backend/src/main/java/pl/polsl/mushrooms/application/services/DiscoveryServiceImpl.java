package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DiscoveryServiceImpl implements DiscoveryService {


    private final DiscoveryDao discoveryDao;
    private final TripDao tripRepository;

    public DiscoveryServiceImpl(
            final DiscoveryDao discoveryDao,
            final TripDao tripDao)
    {
        this.discoveryDao = discoveryDao;
        this.tripRepository = tripDao;
    }
    @Override
    public void handle(CreateDiscoveryCommand command) {

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
    public void handle(UpdateDiscoveryCommand command) {

    }

    @Override
    public void handle(DeleteDiscoveryCommand command) {

    }
}
