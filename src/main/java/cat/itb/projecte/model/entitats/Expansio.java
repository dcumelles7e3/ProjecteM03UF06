package cat.itb.projecte.model.entitats;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expansions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Expansio implements Serializable{
    @Id @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "expansio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Carta> cartes;

    public Expansio(String nom) {
        this.nom = nom;
    }
}
