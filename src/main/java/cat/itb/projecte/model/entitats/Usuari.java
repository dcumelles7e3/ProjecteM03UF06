package cat.itb.projecte.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Usuari{
    @Id
    private String username;
    private String password;
    private String rol;

    public Usuari() {
        rol = "user";
    }

    public Usuari(String user, String pwd) {
        username=user;
        password=new BCryptPasswordEncoder().encode(pwd);
        rol="user";
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Usuari(String username, String password, String rol) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);;
        this.rol = rol;
    }

}
