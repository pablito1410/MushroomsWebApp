package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@RestController
@RequestMapping("/mushrooms/api/1.0")
public class MushroomsServerController {


        // TODO PK Nie usuwać! Przyda się w przyszłości
//    @RequestMapping(path = "store-image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public StoreImageResponse receiveImage(
//            @RequestParam("file") List<MultipartFile> files, @RequestParam("info") String info) {
//
//        ImageData imageData = new ImageData(files, info);
//        StoreImageResponse response = imageService.storeImage(imageData);
//
//        return response;
//    }
}
