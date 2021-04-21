package cat.itb.projecte.repositoris;

import cat.itb.projecte.model.entitats.Carta;
import cat.itb.projecte.model.entitats.Expansio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriExpansions extends JpaRepository<Expansio,Long> {
}
