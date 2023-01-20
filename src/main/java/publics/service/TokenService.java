package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Token;
import publics.repository.Tokenrepository;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    public Tokenrepository tokenRepository;

    public Token save(Token tk) {
        tokenRepository.save(tk);
        return tk;
    }

    public Boolean verification(String valeur, List<Token> tk) throws Exception {
        Optional<Token> deleteToken = tokenRepository.findById(Integer.valueOf(valeur));
        for (int w = 0; w < tk.size(); w++) {
            if (tk.get(w).getValeur().compareToIgnoreCase(valeur) == 0)
                return Token.verification(tk.get(w).getDateexpiration());
        }
        throw new Exception("Veuillez vous connecter");
    }
}
