package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.clazz.CreateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.DeleteMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.UpdateMushroomClassCommand;
import pl.polsl.mushrooms.application.dao.MushroomClassDao;
import pl.polsl.mushrooms.application.model.MushroomClass;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public class MushroomClassServiceImpl implements MushroomClassService {

    private final MushroomClassDao mushroomClassDao;
    private final EntityMapper entityMapper;

    public MushroomClassServiceImpl(
            final MushroomClassDao mushroomClassDao,
            final EntityMapper entityMapper) {
        this.mushroomClassDao = mushroomClassDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateMushroomClassCommand command) {
        final MushroomClass mushroomClass = new MushroomClass(command.getName());
        return mushroomClassDao.save(mushroomClass).getId();
    }

    @Override
    public MushroomClassDto handle(UpdateMushroomClassCommand command) {
        final MushroomClass mushroomClass = mushroomClassDao.findOne(command.getId());
        mushroomClass.setName(command.getName());
        mushroomClassDao.save(mushroomClass);
        return entityMapper.map(mushroomClass);
    }

    @Override
    public void handle(DeleteMushroomClassCommand command) {
        mushroomClassDao.delete(command.getId());
    }
}
