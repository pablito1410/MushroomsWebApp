package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 05.06.2017.
 */
public class UpdateProfileImageCommand implements VoidCommand {

    private final String username;
    private final byte[] photo;

    public UpdateProfileImageCommand(String username, byte[] photo) {
        this.username = username;
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getUsername() {
        return username;
    }
}
