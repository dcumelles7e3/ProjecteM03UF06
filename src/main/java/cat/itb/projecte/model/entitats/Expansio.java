package cat.itb.projecte.model.entitats;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Expansio implements Serializable {
    @Id
    private long id;
    private String nom;
}
