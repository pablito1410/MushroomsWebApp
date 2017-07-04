package pl.polsl.mushrooms.application.services.projections;

import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface CommentProjectionService {
    Map<String,Object> findOne(long id);
}
