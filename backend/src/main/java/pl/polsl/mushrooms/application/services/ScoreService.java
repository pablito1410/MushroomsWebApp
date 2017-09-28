package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.commands.score.DeleteScoreCommand;
import pl.polsl.mushrooms.application.commands.score.UpdateScoreCommand;


public interface ScoreService {

    /**
     * Adds a score to the discovery
     * @param command
     * @return Id of created score
     */
    Long handle(AddScoreCommand command);

    /**
     * Updates the score
     * @param command
     */
    void handle(UpdateScoreCommand command);

    /**
     * Deletes the score
     * @param command
     */
    void handle(DeleteScoreCommand command);
}
