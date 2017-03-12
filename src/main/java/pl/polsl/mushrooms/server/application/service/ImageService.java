package pl.polsl.mushrooms.server.application.service;

import pl.polsl.mushrooms.server.application.api.response.StoreImageResponse;
import pl.polsl.mushrooms.server.application.data.ImageData;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public interface ImageService {

    StoreImageResponse storeImage(ImageData imageData);
}
