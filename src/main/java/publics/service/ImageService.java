package publics.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import publics.model.Image;
import publics.repository.ImageRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class ImageService {
    private final ImageRepo repo;

    public List<Image> getAllClients(){
        return repo.findAll();
    }
    public Image postimage(Image image){
        return repo.save(image);
    }
}
