package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import publics.repository.EnchereRepository;

import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Recherche {

    private String mot;
    private Timestamp date;
    private Integer[] categorie;
    private int prix;
    private Integer statut;
    private Enchere ench;

    public ArrayList<Enchere> search(ArrayList<Enchere> enchere){
        ArrayList<Enchere> ls=new ArrayList<>(enchere);
        ArrayList<Enchere> turn=new ArrayList<>();
        for(int e=0;e<ls.size();e++){
            ench=ls.get(e);
            if(mot()&&date()&&prix()&&categorie()&&statut())
                turn.add(ench);
        }
        return turn;
    }

    private boolean mot(){
        if(this.mot!=null&&ench.getDescription().contains(this.mot))
            return true;
        return false;
    }
    private boolean date(){
        if(this.mot!=null&&ench.getDateMise().compareTo(this.date)==0||ench.getFin().compareTo(this.date)==0)
            return true;
        return false;
    }
    private boolean prix(){
        if(this.prix!=0&&ench.getMinimal()==this.prix)
            return true;
        return false;
    }
    private boolean categorie(){
        if(this.categorie!=null)
            return false;
        for(int x=0;x<this.categorie.length;x++){
            if(this.categorie[x]==ench.getCategorie().getIdcategorie())
                return true;
        }
        return false;
    }
    private boolean statut(){
        if(this.statut!=null&&ench.getStatut()==this.statut)
            return true;
        return false;
    }
}
