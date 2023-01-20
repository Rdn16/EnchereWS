package publics.controller;


import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import publics.model.Image;
import publics.service.Data;
import publics.service.ImageService;

import java.util.List;

@SpringBootApplication
@RestController
@AllArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @GetMapping
    public List<Image> getAllImage(){return imageService.getAllClients();}
    @PostMapping
    public Object createImage(@RequestBody Image image){
        try{
            return new Data(imageService.postimage(image));
        }catch (Exception e) {
            return new Error(e);
        }
    }
}
