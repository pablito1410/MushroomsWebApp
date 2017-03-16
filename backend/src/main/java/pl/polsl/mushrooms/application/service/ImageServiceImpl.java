package pl.polsl.mushrooms.application.service;

import pl.polsl.mushrooms.application.api.response.StoreImageResponse;
import pl.polsl.mushrooms.application.data.ImageData;
import pl.polsl.mushrooms.application.repository.MushroomsRepository;

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
