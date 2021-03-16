package cat.itb.projecte.model.serveis;

import cat.itb.projecte.model.entitats.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dídac Cumelles
 */
@Service
public class ServeiEmpleats {
    private List<Empleat> repositori = new ArrayList<>();
    public void afegir(Empleat e) {
        repositori.add(e);
    }
    public List<Empleat> llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Empleat(1, "Ekis De", "ekis@de.xd", "666333888",false),
                        new Empleat(2, "Como Ere", "como@ere.xd", "699000444",false),
                        new Empleat(3, "Dídac Cumelles", "didac.cumelles@itb.cat", "666730777",true)
                )
        );
    }

    public List<Empleat> llistatOrdenatPerNom(){
        List<Empleat> llistatOrdenatPerNom = repositori;
        llistatOrdenatPerNom.sort(((o1, o2) -> o1.getNom().compareTo(o2.getNom())));
        return llistatOrdenatPerNom;
    }
    public Empleat consultaPerId(int id){
        for (Empleat empleat : repositori) {
            if (empleat.getId()==id){
                return empleat;
            }
        }
        return null;
    }
    public void eliminarPerId(int id){
        repositori.removeIf(empleat -> empleat.getId() == id);
    }
    public void substituir(Empleat e) {
        for (int i = 0; i < repositori.size(); i++) {
            if (repositori.get(i).getId() == e.getId()){
                repositori.set(i,e);
            }
        }
    }

}
