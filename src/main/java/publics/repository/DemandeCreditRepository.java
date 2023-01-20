package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.DemandeCredit;

public interface DemandeCreditRepository extends JpaRepository<DemandeCredit,Integer> {
    //All crud
}
