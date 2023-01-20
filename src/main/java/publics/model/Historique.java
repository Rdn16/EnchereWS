package publics.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historique")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idhistorique;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idenchere")
    private Enchere enchere;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private User user;

    @Column(name = "periode")
    private Timestamp periode;

    @Column(name = "prix")
    private int prix;

    public static boolean checkPrix(Historique historique, List<Historique> historiqueList){
        Boolean result=false;
        for (int i=0;i<historiqueList.size();i++) {
            Historique h = (Historique) historiqueList.get(i);
            if (h.getPrix() > historique.getPrix()&& historique.getPrix()>=h.getEnchere().getMinimal()) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

}
