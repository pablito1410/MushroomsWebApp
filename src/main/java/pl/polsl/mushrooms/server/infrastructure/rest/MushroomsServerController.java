package pl.polsl.mushrooms.server.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.polsl.mushrooms.server.application.api.request.CreateUserRequest;
import pl.polsl.mushrooms.server.application.api.request.LogInRequest;
import pl.polsl.mushrooms.server.application.api.response.StoreImageResponse;
import pl.polsl.mushrooms.server.application.api.response.UserLogInResponse;
import pl.polsl.mushrooms.server.application.data.ImageData;
import pl.polsl.mushrooms.server.application.service.ImageService;
import pl.polsl.mushrooms.server.application.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@RestController
@RequestMapping("/mushrooms/api/1.0/")
public class MushroomsServerController {

    private UserService userService;
    private ImageService imageService;

    @Autowired
    public MushroomsServerController(UserService userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    @RequestMapping(path = "create-user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {

        final UUID id = userService.createUser(request);

        return ResponseEntity.created(URI.create("/low-and-wide/api/1.0/" + id)).build();
    }

    @RequestMapping(path = "log-in", method = RequestMethod.POST)
    public UserLogInResponse logIn(@RequestBody LogInRequest request) {

        final UserLogInResponse response = userService.logIn(request);

        return response;
    }

    @RequestMapping(path = "store-image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public StoreImageResponse receiveImage(
            @RequestParam("file") List<MultipartFile> files, @RequestParam("info") String info) {

        ImageData imageData = new ImageData(files, info);
        StoreImageResponse response = imageService.storeImage(imageData);

        return response;
    }
}
