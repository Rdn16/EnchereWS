package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokenage")

public class TokenAge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idtokenage;
    @Column(name = "valeur")
    private int valeur;
}
