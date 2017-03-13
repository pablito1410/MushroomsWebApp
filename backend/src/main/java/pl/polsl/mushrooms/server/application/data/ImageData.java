package pl.polsl.mushrooms.server.application.data;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public class ImageData {


    private final List<MultipartFile> files;
    private final String info;

    public ImageData(List<MultipartFile> files, String info) {
        this.files = files;
        this.info = info;
    }
}
