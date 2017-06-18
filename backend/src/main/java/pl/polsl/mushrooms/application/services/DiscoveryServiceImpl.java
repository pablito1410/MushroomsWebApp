package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.MushroomSpeciesDao;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DiscoveryServiceImpl implements DiscoveryService {


    private final DiscoveryDao discoveryDao;
    private final TripDao tripDao;
    private final UserDao userDao;
    private final MushroomSpeciesDao mushroomSpeciesDao;

    public DiscoveryServiceImpl(
            final DiscoveryDao discoveryDao,
            final TripDao tripDao,
            final UserDao userDao,
            final MushroomSpeciesDao mushroomSpeciesDao)
    {
        this.discoveryDao = discoveryDao;
        this.tripDao = tripDao;
        this.userDao = userDao;
        this.mushroomSpeciesDao = mushroomSpeciesDao;
    }
    @Override
    public long handle(CreateDiscoveryCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer mushroomer = (Mushroomer)userDao.findOneByUsername(currentUsername);
        final Trip trip = tripDao.findTrip(command.getTripId());
        final MushroomSpecies mushroomSpecie = mushroomSpeciesDao.findOne(command.getMushroomSpieceId());
        final Discovery discovery = new Discovery(
            command.getCoordinateX(),
            command.getCoordinateY(),
            command.getPhoto(),
            command.getDateTime(),
            trip,
            mushroomSpecie,
            mushroomer
        );

        discoveryDao.save(discovery);

        return discovery.getId();
    }

    @Override
    public void handle(UpdateDiscoveryCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer mushroomer = (Mushroomer)userDao.findOneByUsername(currentUsername);
        final Discovery discovery =  discoveryDao.findDiscovery(command.getId());
        if (discovery == null || !discovery.getMushroomer().equals(mushroomer)) {
            // TODO
        }
        else
        {
            discovery.setDateTime(command.getDateTime());
            discovery.setCoordinateX(command.getCoordinateX());
            discovery.setCoordinateY(command.getCoordinateY());
            discovery.setPhoto(command.getPhoto());
            discovery.setMushroomSpecies(mushroomSpeciesDao.findOne(command.getMushroomSpieceId()));
//            discovery.setTags(); TODO
        }
    }

    @Override
    public void handle(DeleteDiscoveryCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer mushroomer = (Mushroomer)userDao.findOneByUsername(currentUsername);
        final Discovery discovery =  discoveryDao.findDiscovery(command.getId());
        if (discovery == null || !discovery.getMushroomer().equals(mushroomer)) {
            // TODO
        } else {
            discoveryDao.delete(discovery.getId());
        }
    }
}
