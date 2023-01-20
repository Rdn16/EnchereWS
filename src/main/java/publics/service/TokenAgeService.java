package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.TokenAge;
import publics.repository.TokenAgerepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TokenAgeService {
    @Autowired
    private TokenAgerepository tokenAgeRepo;

    public List<TokenAge> findAll() {
        return tokenAgeRepo.findAll();
    }

    public TokenAge getOne() {
        return this.findAll().get(0);
    }

    public Timestamp expiration() {
        LocalDateTime now = LocalDateTime.now();
        Timestamp delai = Timestamp.valueOf(now);
        TokenAge age = this.getOne();
        delai.setTime(delai.getTime() + TimeUnit.MINUTES.toMillis(age.getValeur()));
        return delai;
    }
}
