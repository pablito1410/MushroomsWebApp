package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.TagDao;
import pl.polsl.mushrooms.application.model.Tag;
import pl.polsl.mushrooms.infrastructure.repositories.TagRepository;


public class TagDaoImpl implements TagDao {

    private final TagRepository tagRepository;

    public TagDaoImpl(final TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag findOne(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        tagRepository.delete(id);
    }
}
