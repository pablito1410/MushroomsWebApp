package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomOrderDao;
import pl.polsl.mushrooms.application.model.MushroomOrder;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomOrderRepository;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomOrderDaoImpl implements MushroomOrderDao {

    private final MushroomOrderRepository mushroomOrderRepository;

    public MushroomOrderDaoImpl(
            final MushroomOrderRepository mushroomOrderRepository) {
        this.mushroomOrderRepository = mushroomOrderRepository;
    }

    @Override
    public MushroomOrder save(final MushroomOrder mushroomOrder) {
        return mushroomOrderRepository.save(mushroomOrder);
    }

    @Override
    public MushroomOrder findOne(long mushroomOrderId) {
        return mushroomOrderRepository.findOne(mushroomOrderId);
    }

    @Override
    public void delete(long id) {
        mushroomOrderRepository.delete(id);
    }
}
