package cat.itb.projecte.model.serveis;

import cat.itb.projecte.model.entitats.Usuari;
import cat.itb.projecte.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiUsuaris {
    @Autowired
    private RepositoriUsuaris repositori;

    public void afegir(Usuari e) {
        repositori.save(e);
    }

    @PostConstruct
    public void init() {
        Iterable<Usuari> inicials = Arrays.asList(
                new Usuari("daidis", "ekisde", "admin"),
                new Usuari("montse", "montse", "admin"),
                new Usuari("user", "user")
        );
        repositori.saveAll(inicials);
    }

    public Usuari findById(String username) {
        return repositori.findById(username).orElse(null);
    }

}
