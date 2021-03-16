package cat.itb.projecte.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuari{
    private String username;
    private String password;
    private String rol; //"USER" o "ADMIN"

    public Usuari(String user, String pwd) {
        username=user;
        password=pwd;
        rol="USER"; //per defecte, tothom és USER
    }
}
