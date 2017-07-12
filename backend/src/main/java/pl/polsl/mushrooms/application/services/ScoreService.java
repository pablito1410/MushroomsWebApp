package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.commands.score.DeleteScoreCommand;
import pl.polsl.mushrooms.application.commands.score.UpdateScoreCommand;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public interface ScoreService {

    Long handle(AddScoreCommand command);

    void handle(UpdateScoreCommand command);

    void handle(DeleteScoreCommand command);
}
