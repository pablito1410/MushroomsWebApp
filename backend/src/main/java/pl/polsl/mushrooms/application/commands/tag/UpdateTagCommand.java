package pl.polsl.mushrooms.application.commands.tag;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class UpdateTagCommand implements ReturningCommand<TagDto> {

    @Transient
    private String userName;

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
