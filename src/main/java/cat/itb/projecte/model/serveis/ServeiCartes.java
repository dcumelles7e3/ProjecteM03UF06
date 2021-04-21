package cat.itb.projecte.model.serveis;

import cat.itb.projecte.model.entitats.Carta;
import cat.itb.projecte.model.entitats.Expansio;
import cat.itb.projecte.model.entitats.Usuari;
import cat.itb.projecte.repositoris.RepositoriCartes;
import cat.itb.projecte.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiCartes {
    @Autowired
    private RepositoriCartes repositori;

    public void afegir(Carta c) {
        repositori.save(c);
    }

    public List<Carta> llistat() {
        return repositori.findAll();
    }

    @PostConstruct
    public void init() {
        Expansio ravnica = new Expansio("Ravnica");
        Expansio coreset = new Expansio("Core Set 2020");
        List<Carta> inicials = Arrays.asList(
                new Carta("Elfos de Llanowar",1,1,"Ekisde",ravnica),
                new Carta("Engendro del Caos",4,4,"Vuela, arrolla.",ravnica),
                new Carta("Apóstol de la luz",1,2,"Protección contra negro",coreset),
                new Carta("Recaudador de diezmos",1,2,"Ultratumba 1",ravnica),
                new Carta("Ángel de la vitalidad",2,2,"Vuela",coreset)
        );
        repositori.saveAll(inicials);
    }

    public List<Carta> findSortExpansio(){
        return repositori.findAllByOrderByExpansioDescNomAsc();
    }

    public Carta findById(long id) {
        return repositori.findById(id).orElse(null);
    }
    public void eliminarPerId(long id){
        repositori.deleteById(id);
    }

    public void substituir(Carta c) {
        repositori.save(c);

    }
}