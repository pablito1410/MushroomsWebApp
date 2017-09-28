package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.tag.CreateTagCommand;
import pl.polsl.mushrooms.application.commands.tag.DeleteTagCommand;
import pl.polsl.mushrooms.application.commands.tag.UpdateTagCommand;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;


public interface TagService {

    /**
     * Creates a new tag
     * @param command
     * @return Id of the created tag
     */
    long handle(CreateTagCommand command);

    /**
     * Updates the tag
     * @param command
     * @return Updated tag
     */
    TagDto handle(UpdateTagCommand command);

    /**
     * Deletes the tag
     * @param command
     */
    void handle(DeleteTagCommand command);
}
