package cat.itb.projecte.repositoris;

import cat.itb.projecte.model.entitats.Carta;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriCartes extends CrudRepository<Carta,Long> {
}
