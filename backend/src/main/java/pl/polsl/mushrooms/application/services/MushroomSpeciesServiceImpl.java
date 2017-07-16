package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.species.CreateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.DeleteMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.UpdateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.dao.MushroomGenusDao;
import pl.polsl.mushrooms.application.dao.MushroomSpeciesDao;
import pl.polsl.mushrooms.application.model.MushroomGenus;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class MushroomSpeciesServiceImpl implements MushroomSpeciesService {
    
    private final MushroomGenusDao mushroomGenusDao;
    private final MushroomSpeciesDao mushroomSpeciesDao;
    private final EntityMapper entityMapper;

    public MushroomSpeciesServiceImpl(
            final MushroomGenusDao mushroomGenusDao, 
            final MushroomSpeciesDao mushroomSpeciesDao, 
            final EntityMapper entityMapper) {
        this.mushroomGenusDao = mushroomGenusDao;
        this.mushroomSpeciesDao = mushroomSpeciesDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateMushroomSpeciesCommand command) {
        final MushroomGenus mushroomGenus = mushroomGenusDao.findOne(command.getMushroomGenusId());
        final MushroomSpecies mushroomSpecies = new MushroomSpecies(
                command.getName(),
                command.getExamplePhoto(),
                mushroomGenus);
        return mushroomSpeciesDao.save(mushroomSpecies).getId();
    }

    @Override
    public MushroomSpeciesDto handle(UpdateMushroomSpeciesCommand command) {
        final MushroomGenus mushroomGenus = mushroomGenusDao.findOne(command.getMushroomGenusId());
        final MushroomSpecies mushroomSpecies = mushroomSpeciesDao.findOne(command.getId());
        mushroomSpecies.setName(command.getName());
        mushroomSpecies.setExamplePhoto(command.getExamplePhoto());
        mushroomSpecies.setGenus(mushroomGenus);
        mushroomSpeciesDao.save(mushroomSpecies);
        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public void handle(DeleteMushroomSpeciesCommand command) {
        mushroomSpeciesDao.delete(command.getId());
    }
}
