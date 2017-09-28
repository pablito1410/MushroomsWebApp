package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.model.*;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.HashSet;
import java.util.Set;


public class DiscoveryServiceImpl implements DiscoveryService {


    private final DiscoveryDao discoveryDao;
    private final TripDao tripDao;
    private final UserDao userDao;
    private final MushroomSpeciesDao mushroomSpeciesDao;
    private final ScoreDao scoreDao;

    public DiscoveryServiceImpl(
            final DiscoveryDao discoveryDao,
            final TripDao tripDao,
            final UserDao userDao,
            final MushroomSpeciesDao mushroomSpeciesDao,
            ScoreDao scoreDao)
    {
        this.discoveryDao = discoveryDao;
        this.tripDao = tripDao;
        this.userDao = userDao;
        this.mushroomSpeciesDao = mushroomSpeciesDao;
        this.scoreDao = scoreDao;
    }
    @Override
    public long handle(CreateDiscoveryCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer mushroomer = (Mushroomer)userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);;

        final Trip trip = tripDao.findTrip(command.getTripId());
        if (trip == null) {
            throw new NotFoundException("Trip not found");
        }

        final MushroomSpecies mushroomSpecie = mushroomSpeciesDao.findOne(command.getMushroomSpeciesId());
        if (mushroomSpecie == null) {
            throw new NotFoundException("MushtoomSpecies nof found");
        }

         final Discovery discovery = new Discovery(
            command.getCoordinateX(),
            command.getCoordinateY(),
            command.getPhoto(),
            command.getDateTime(),
            trip,
            mushroomSpecie,
            mushroomer,
            command.getIsPublic()
        );

        if (command.getTags() != null) {
            Set<Tag> tags = new HashSet<>();
            command.getTags().forEach(t -> tags.add(new Tag(t, discovery)));
            discovery.setTags(tags);
        }

        discoveryDao.save(discovery);

        return discovery.getId();
    }

    @Override
    public void handle(UpdateDiscoveryCommand command) {
        final String currentUsername = command.getUserName();
        final User user = userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);;
        final Discovery discovery =
                discoveryDao.findOne(command.getId())
                    .orElseThrow(NotFoundException::new);

        if (user.isAdmin()) {
            updateDiscovery(discovery, command);
        }
        else if (discovery.getMushroomer().equals(user)) {
            updateDiscovery(discovery, command);
        } else {
            throw new NotAuthorizedException("This discovery was not created by user with id=" + user.getId());
        }
    }

    private void updateDiscovery(final Discovery discovery, final UpdateDiscoveryCommand command) {
        discovery.setDateTime(command.getDateTime());
        discovery.setCoordinateX(command.getCoordinateX());
        discovery.setCoordinateY(command.getCoordinateY());
//        discovery.setPhoto(command.getPhoto());
        discovery.setMushroomSpecies(mushroomSpeciesDao.findOne(command.getMushroomSpeciesId()));

        if (command.getTags() != null) {
            final Set<Tag> tags = new HashSet<>();
            command.getTags().forEach(t -> tags.add(new Tag(t, discovery)));
            discovery.setTags(tags);
        }

        discoveryDao.save(discovery);
    }

    @Override
    public void handle(DeleteDiscoveryCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer mushroomer = (Mushroomer)userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);;
        final Discovery discovery =
                discoveryDao.findOne(command.getId())
                    .orElseThrow(NotFoundException::new);

        if (!discovery.getMushroomer().equals(mushroomer)) {
            throw new NotAuthorizedException("This discovery was not created by user with id=" + mushroomer.getId());
        }

        discoveryDao.delete(discovery.getId());
    }

}
