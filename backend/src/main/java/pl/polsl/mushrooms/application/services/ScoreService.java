package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public interface ScoreService {

    void handle(AddScoreCommand command);
}
