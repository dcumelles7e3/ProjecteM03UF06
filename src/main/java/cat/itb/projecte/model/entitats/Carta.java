package cat.itb.projecte.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartes")
public class Carta implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String nom;
    private int hp;
    private int atk;
    private String desc;
    @ManyToOne(cascade = CascadeType.ALL)
    private Expansio expansio;

    public Carta(String nom, int hp, int atk, String desc, Expansio expansio) {
        this.nom = nom;
        this.hp = hp;
        this.atk = atk;
        this.desc = desc;
        this.expansio = expansio;
    }
}
