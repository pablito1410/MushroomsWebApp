package pl.polsl.mushrooms.server.application.service;

import pl.polsl.mushrooms.server.application.api.response.StoreImageResponse;
import pl.polsl.mushrooms.server.application.data.ImageData;
import pl.polsl.mushrooms.server.application.repository.MushroomsRepository;

/**
 * Created by pawel_zaqkxkn on 13.03.2017.
 */
public class ImageServiceImpl implements ImageService {


    private final MushroomsRepository repo;

    public ImageServiceImpl(MushroomsRepository repo) {

        this.repo = repo;
    }

    @Override
    public StoreImageResponse storeImage(ImageData imageData) {
        return null;
    }
}
