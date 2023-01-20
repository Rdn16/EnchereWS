package publics.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Formatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    private String valeur;
    @Column(name = "idadmin")
    private int idadmin;
    @Column(name = "dateexpiration")
    private Timestamp dateexpiration;

    public Token(String valeur, int idadmin) {
        this.valeur = valeur;
        this.idadmin = idadmin;
    }

    public static String generateToken(String admin) throws Exception {
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String change = admin + ts.toString();
        byte[] bt = md.digest(change.getBytes());
        Formatter formatter = new Formatter();
        for (byte b : bt) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static Boolean verification(Timestamp delai) throws Exception {
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        if (delai.after(ts))
            return true;
        throw new Exception("session expiré");
    }
}
