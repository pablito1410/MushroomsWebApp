package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.family.CreateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.DeleteMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.UpdateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.dao.MushroomFamilyDao;
import pl.polsl.mushrooms.application.dao.MushroomOrderDao;
import pl.polsl.mushrooms.application.model.MushroomFamily;
import pl.polsl.mushrooms.application.model.MushroomOrder;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;


public class MushroomFamilyServiceImpl implements MushroomFamilyService {

    private final MushroomOrderDao mushroomOrderDao;
    private final MushroomFamilyDao mushroomFamilyDao;
    private final EntityMapper entityMapper;

    public MushroomFamilyServiceImpl(
            final MushroomOrderDao mushroomOrderDao,
            final MushroomFamilyDao mushroomFamilyDao,
            final EntityMapper entityMapper) {
        this.mushroomOrderDao = mushroomOrderDao;
        this.mushroomFamilyDao = mushroomFamilyDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateMushroomFamilyCommand command) {
        final MushroomOrder mushroomOrder = mushroomOrderDao.findOne(command.getMushroomOrderId());
        final MushroomFamily mushroomFamily =  new MushroomFamily(command.getName(), mushroomOrder);
        return mushroomFamilyDao.save(mushroomFamily).getId();
    }

    @Override
    public MushroomFamilyDto handle(UpdateMushroomFamilyCommand command) {
        final MushroomFamily mushroomFamily = mushroomFamilyDao.findOne(command.getId());
        mushroomFamily.setName(command.getName());
        mushroomFamilyDao.save(mushroomFamily);
        return entityMapper.map(mushroomFamily);
    }

    @Override
    public void handle(DeleteMushroomFamilyCommand command) {
        mushroomFamilyDao.delete(command.getId());
    }
}
