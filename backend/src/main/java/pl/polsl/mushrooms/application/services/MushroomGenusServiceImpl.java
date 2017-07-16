package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.genus.CreateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.DeleteMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.UpdateMushroomGenusCommand;
import pl.polsl.mushrooms.application.dao.MushroomFamilyDao;
import pl.polsl.mushrooms.application.dao.MushroomGenusDao;
import pl.polsl.mushrooms.application.model.MushroomFamily;
import pl.polsl.mushrooms.application.model.MushroomGenus;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomGenusServiceImpl implements MushroomGenusService {

    private final MushroomFamilyDao mushroomFamilyDao;
    private final MushroomGenusDao mushroomGenusDao;
    private final EntityMapper entityMapper;

    public MushroomGenusServiceImpl(
            final MushroomFamilyDao mushroomFamilyDao,
            final MushroomGenusDao mushroomGenusDao,
            final EntityMapper entityMapper) {

        this.mushroomFamilyDao = mushroomFamilyDao;
        this.mushroomGenusDao = mushroomGenusDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateMushroomGenusCommand command) {
        final MushroomFamily mushroomFamily = mushroomFamilyDao.findOne(command.getMushroomFamilyId());
        final MushroomGenus mushroomGenus =  new MushroomGenus(command.getName(), mushroomFamily);
        return mushroomGenusDao.save(mushroomGenus).getId();
    }

    @Override
    public MushroomGenusDto handle(UpdateMushroomGenusCommand command) {
        final MushroomGenus mushroomGenus = mushroomGenusDao.findOne(command.getId());
        mushroomGenus.setName(command.getName());
        mushroomGenusDao.save(mushroomGenus);
        return entityMapper.map(mushroomGenus);
    }

    @Override
    public void handle(DeleteMushroomGenusCommand command) {
        mushroomGenusDao.delete(command.getId());
    }
}
