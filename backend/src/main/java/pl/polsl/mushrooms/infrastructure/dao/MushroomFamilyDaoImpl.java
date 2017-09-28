package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomFamilyDao;
import pl.polsl.mushrooms.application.model.MushroomFamily;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomFamilyRepository;


public class MushroomFamilyDaoImpl implements MushroomFamilyDao {

    private final MushroomFamilyRepository mushroomFamilyRepository;

    public MushroomFamilyDaoImpl(
            final MushroomFamilyRepository mushroomFamilyRepository) {
        this.mushroomFamilyRepository = mushroomFamilyRepository;
    }

    @Override
    public MushroomFamily save(final MushroomFamily mushroomFamily) {
        return mushroomFamilyRepository.save(mushroomFamily);
    }

    @Override
    public MushroomFamily findOne(long mushroomFamilyId) {
        return mushroomFamilyRepository.findOne(mushroomFamilyId);
    }

    @Override
    public void delete(long mushroomFamilyId) {
        mushroomFamilyRepository.delete(mushroomFamilyId);
    }
}
