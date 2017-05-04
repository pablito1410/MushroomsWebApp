package pl.polsl.mushrooms.infrastructure.projections;

import org.springframework.data.rest.core.config.Projection;
import pl.polsl.mushrooms.application.model.User;

/**
 * Created by pawel_zaqkxkn on 26.04.2017.
 */
@Projection(name = "userBaseInfo", types = {User.class})
public interface UserBaseInfo {

    String getUsername();

    String getEmail();
}
