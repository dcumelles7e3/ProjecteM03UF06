package cat.itb.projecte.model.serveis;

import cat.itb.projecte.model.entitats.Carta;
import cat.itb.projecte.model.entitats.Usuari;
import cat.itb.projecte.repositoris.RepositoriCartes;
import cat.itb.projecte.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class ServeiCartes {
    @Autowired
    private RepositoriCartes repositori;

    public void afegir(Carta c) {
        repositori.save(c);
    }

    public Iterable<Carta> llistat() {
        return repositori.findAll();
    }

    @PostConstruct
    public void init() {
        Iterable<Usuari> inicials = Arrays.asList(
                new Usuari("daidis", "ekisde", "admin"),
                new Usuari("montse", "montse", "admin"),
                new Usuari("user", "user")
        );
       // repositori.saveAll(inicials);
    }

 /*   public Usuari findById(String username) {
        return repositori.findById(username).orElse(null);
    }*/

}