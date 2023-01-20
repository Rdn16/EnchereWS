package publics.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Image")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {
    private int idenchere;

    private String photo;

    public Image() {
    }

    public Image(int idenchere, String profil) {
        this.idenchere = idenchere;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idenchere=" + idenchere +
                ", photo='" + photo + '\'' +
                '}';
    }
}
