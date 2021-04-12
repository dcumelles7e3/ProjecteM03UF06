package cat.itb.projecte.repositoris;

import cat.itb.projecte.model.entitats.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari,String> {
}
