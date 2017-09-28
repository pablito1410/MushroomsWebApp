package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomOrderProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomOrder;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomOrderRepository;

import java.util.List;
import java.util.Set;


public class MushroomOrderProjectionDaoImpl implements MushroomOrderProjectionDao {

    private final MushroomOrderRepository mushroomOrderRepository;
    private final EntityMapper entityMapper;

    public MushroomOrderProjectionDaoImpl(
            final MushroomOrderRepository mushroomOrderRepository,
            final EntityMapper entityMapper) {
        this.mushroomOrderRepository = mushroomOrderRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<MushroomOrderDto> findAll(long userId) {
//        throw new NotYetImplementedException();
//    }

    @Override
    public Set<MushroomOrderDto> findAll() {
        final List<MushroomOrder> mushroomOrders = mushroomOrderRepository.findAll();
        return entityMapper.map(mushroomOrders);
    }

    @Override
    public MushroomOrderDto findOne(long id) {
        final MushroomOrder mushroomOrder = mushroomOrderRepository.findOne(id);
        return entityMapper.map(mushroomOrder);
    }

    @Override
    public Set<MushroomOrderDto> search(String value) {
        final List<MushroomOrder> mushroomOrderes
                = mushroomOrderRepository.findByNameIgnoreCaseContaining(value);
        return entityMapper.map(mushroomOrderes);
    }
}
