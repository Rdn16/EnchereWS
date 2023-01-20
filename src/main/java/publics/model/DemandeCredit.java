package publics.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demandecredit")
public class DemandeCredit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddm;
    @Column(name="iduser")
    private int iduser;
    @Column(name="periode")
    private Date periode;
    @Column(name="somme")
    private int somme;

}
