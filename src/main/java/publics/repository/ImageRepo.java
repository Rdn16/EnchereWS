package publics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import publics.model.Image;

@Repository
public interface ImageRepo extends MongoRepository<Image,Integer> {
}
