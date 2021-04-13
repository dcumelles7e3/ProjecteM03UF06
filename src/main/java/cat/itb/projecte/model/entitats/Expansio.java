package cat.itb.projecte.model.entitats;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expansions")
public class Expansio implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String nom;
    @OneToMany(mappedBy = "expansio")
    private Set<Carta> cartes;

    public Expansio(String nom) {
        this.nom = nom;
    }
}
