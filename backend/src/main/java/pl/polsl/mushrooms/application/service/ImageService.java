package pl.polsl.mushrooms.application.service;

import pl.polsl.mushrooms.application.api.response.StoreImageResponse;
import pl.polsl.mushrooms.application.data.ImageData;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public interface ImageService {

    StoreImageResponse storeImage(ImageData imageData);
}
