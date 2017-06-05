package pl.polsl.mushrooms.application.commands.user;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 05.06.2017.
 */
public class UpdateProfileImageCommand extends CommonsMultipartFile implements VoidCommand {

    /**
     * Create an instance wrapping the given FileItem.
     *
     * @param fileItem the FileItem to wrap
     */
    public UpdateProfileImageCommand(FileItem fileItem) {
        super(fileItem);
    }
}
