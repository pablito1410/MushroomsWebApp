package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.order.CreateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.DeleteMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.UpdateMushroomOrderCommand;
import pl.polsl.mushrooms.application.dao.MushroomClassDao;
import pl.polsl.mushrooms.application.dao.MushroomOrderDao;
import pl.polsl.mushrooms.application.model.MushroomClass;
import pl.polsl.mushrooms.application.model.MushroomOrder;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomOrderServiceImpl implements MushroomOrderService {

    private final MushroomClassDao mushroomClassDao;
    private final MushroomOrderDao mushroomOrderDao;
    private final EntityMapper entityMapper;

    public MushroomOrderServiceImpl(
            final MushroomClassDao mushroomClassDao,
            final MushroomOrderDao mushroomOrderDao,
            final EntityMapper entityMapper) {
        this.mushroomClassDao = mushroomClassDao;
        this.mushroomOrderDao = mushroomOrderDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateMushroomOrderCommand command) {
        final MushroomClass mushroomClass = mushroomClassDao.findOne(command.getMushroomClassId());
        final MushroomOrder mushroomOrder
                = new MushroomOrder(command.getName(), mushroomClass);
        return mushroomOrderDao.save(mushroomOrder).getId();
    }

    @Override
    public MushroomOrderDto handle(UpdateMushroomOrderCommand command) {
        final MushroomOrder mushroomOrder = mushroomOrderDao.findOne(command.getId());
        mushroomOrder.setName(command.getName());
        mushroomOrderDao.save(mushroomOrder);
        return entityMapper.map(mushroomOrder);
    }

    @Override
    public void handle(DeleteMushroomOrderCommand command) {
        mushroomOrderDao.delete(command.getId());
    }
}
