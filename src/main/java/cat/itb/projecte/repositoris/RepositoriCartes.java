package cat.itb.projecte.repositoris;

import cat.itb.projecte.model.entitats.Carta;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RepositoriCartes extends JpaRepository<Carta,Long> {
    public List<Carta> findAllByOrderByHpAsc();
    public List<Carta> findAllByOrderByAtkAsc();
}
