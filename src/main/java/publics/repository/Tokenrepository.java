package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.Token;

public interface Tokenrepository extends JpaRepository<Token, Integer> {
}
