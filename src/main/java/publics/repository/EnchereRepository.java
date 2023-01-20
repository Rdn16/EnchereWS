package publics.repository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Enchere;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnchereRepository extends JpaRepository<Enchere,String> {
    @Query(value = "select * from v_enchere",nativeQuery = true)
    List<Enchere> nonVendue();
    @Query(value = "select * from v_enchereFin where idenchere=:idenchere",nativeQuery = true)
    Enchere byId(int idenchere);
    @Query(value = "select * from v_enchereFin",nativeQuery = true)
    List<Enchere> findAll();

    @Query(value = "select * from enchere where idenchere=:idenchere",nativeQuery = true)
    Enchere byIdEnCours(int idenchere);

    @Query (value="select * from enchere where 1=1 :condition",nativeQuery = true)
    List<Enchere> recherche(String condition);
}


