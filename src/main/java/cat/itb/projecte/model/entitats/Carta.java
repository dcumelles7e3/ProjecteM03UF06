package cat.itb.projecte.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class Carta implements Serializable {
    @Id
    private long id;
    private String nom;
    private int hp;
    private int atk;
    private String desc;
    @ManyToOne
    private Expansio expansio;
}
