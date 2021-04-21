package cat.itb.projecte.model.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "hp")
    private int hp;
    @Column(name = "atk")
    private int atk;
    @Column(name = "descr")
    private String descr;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "expansio_id", referencedColumnName = "id")
//    @Column(name = "expansio", columnDefinition = "LONGVARBINARY")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expansio_id")
    @JsonIgnore
    private Expansio expansio;


    public Carta(String nom, int hp, int atk, String descr, Expansio expansio) {
        this.nom = nom;
        this.hp = hp;
        this.atk = atk;
        this.descr = descr;
        this.expansio = expansio;
    }
}
