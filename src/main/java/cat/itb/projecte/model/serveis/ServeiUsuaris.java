package cat.itb.projecte.model.serveis;

import cat.itb.projecte.model.entitats.Usuari;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiUsuaris {
    private List<Usuari> repositori = new ArrayList<>();
    public void afegir(Usuari e) {
        repositori.add(e);
    }
    public List<Usuari> llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.add(
                        new Usuari("daidis","ekisde","admin")
        );
    }
    public Usuari consultaPerId(String s) {
        for (Usuari usuari : repositori) {
            if (usuari.getUsername().equals(s)){
                return usuari;
            }
        }
        return null;
    }
}
