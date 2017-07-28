package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.tag.CreateTagCommand;
import pl.polsl.mushrooms.application.commands.tag.DeleteTagCommand;
import pl.polsl.mushrooms.application.commands.tag.UpdateTagCommand;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public interface TagService {

    long handle(CreateTagCommand command);

    TagDto handle(UpdateTagCommand command);

    void handle(DeleteTagCommand command);
}
