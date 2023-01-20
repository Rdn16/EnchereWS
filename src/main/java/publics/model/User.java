package publics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    @Column(name = "email")
    private String email;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "mdp")
    private String mot;

    public static int auth(User user, List<User> list) {
        for (int r = 0; r < list.size(); r++) {
            User comp = (User) list.get(r);
            if (comp.getEmail().compareTo(user.getEmail()) == 0 && comp.getMot().compareTo(user.getMot()) == 0)
                return comp.getIduser();
        }

        return 0;
    }
}