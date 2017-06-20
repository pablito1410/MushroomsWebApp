package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.mushrooms.application.model.Score;

/**
 * Created by pawel_zaqkxkn on 20.06.2017.
 */
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
