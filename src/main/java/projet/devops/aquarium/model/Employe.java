package projet.devops.aquarium.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employe {

    @Id
    @GeneratedValue
    private int id;
    private String pseudo;
    private String mdp;

    //constructeur par défaut
    public Employe() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
