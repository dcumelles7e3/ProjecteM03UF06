package cat.itb.projecte.repositoris;

import cat.itb.projecte.model.entitats.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface RepositoriCartes extends JpaRepository<Carta,Long> {
}
