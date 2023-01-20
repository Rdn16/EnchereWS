package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enchere")
public class EnchereV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idenchere;
    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "idproprietaire")
    private int idproprietaire;
    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "idcategorie")
    private int idcategorie;
    @Column(name = "produit")
    private String produit;

    @Column(name = "description")
    private String description;
    @Column(name = "mise")
    private int mise;
    @Column(name = "minimal")
    private int minimal;
    @Column(name = "duree")
    private double duree;

}
