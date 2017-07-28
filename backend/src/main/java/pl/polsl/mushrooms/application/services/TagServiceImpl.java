package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.tag.CreateTagCommand;
import pl.polsl.mushrooms.application.commands.tag.DeleteTagCommand;
import pl.polsl.mushrooms.application.commands.tag.UpdateTagCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.TagDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Tag;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public class TagServiceImpl implements TagService {

    private final DiscoveryDao discoveryDao;
    private final TagDao tagDao;
    private final EntityMapper entityMapper;

    public TagServiceImpl(
            final DiscoveryDao discoveryDao,
            final TagDao tagDao,
            final EntityMapper entityMapper) {
        this.discoveryDao = discoveryDao;
        this.tagDao = tagDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateTagCommand command) {
        final Discovery discovery = discoveryDao.findDiscovery(command.getDiscoveryId());
        final Tag tag = new Tag(
                command.getName(),
                discovery
        );
        return tagDao.save(tag).getId();
    }

    @Override
    public TagDto handle(UpdateTagCommand command) {
        final Tag tag = tagDao.findOne(command.getId());
        tag.setName(command.getName());
        return entityMapper.map(tag);
    }

    @Override
    public void handle(DeleteTagCommand command) {
        tagDao.delete(command.getId());
    }
}
