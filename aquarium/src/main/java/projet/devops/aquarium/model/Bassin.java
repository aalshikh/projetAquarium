package projet.devops.aquarium.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Bassin {

    @Id
    @GeneratedValue
    private int id;
    private String nomBassin;
    private int tailleMax;
    private int tailleUtilise;
    private Date dernierNetoyage;
    private String etatBassin;

    @ManyToOne
    @JoinColumn
    private Secteur secteur;

    @OneToMany(mappedBy="bassin")
    private Set<Animal> animals;

    public Bassin(int id, String nomBassin, int tailleMax, int tailleUtilise, Date dernierNetoyage, String etatBassin, int idSecteur) {
        this.id = id;
        this.nomBassin = nomBassin;
        this.tailleMax = tailleMax;
        this.tailleUtilise = tailleUtilise;
        this.dernierNetoyage = dernierNetoyage;
        this.etatBassin = etatBassin;
    }

    //constructeur par défaut
    public Bassin() {
    }

    public int getId() { return id; }

    public String getNomBassin() { return nomBassin; }

    public int getTailleMax() { return tailleMax; }

    public int getTailleUtilise() { return tailleUtilise; }

    public Date getDernierNetoyage() { return dernierNetoyage; }

    public String getEtatBassin() { return etatBassin; }

    public void setId(int id) { this.id = id; }

    public void setNomBassin(String nomBassin) { this.nomBassin = nomBassin; }

    public void setTailleMax(int tailleMax) { this.tailleMax = tailleMax; }

    public void setTailleUtilise(int tailleUtilise) { this.tailleUtilise = tailleUtilise; }

    public void setDernierNetoyage(Date dernierNetoyage) { this.dernierNetoyage = dernierNetoyage; }

    public void setEtatBassin(String etatBassin) { this.etatBassin = etatBassin; }

    @Override
    public String toString() {
        return "Bassin{" +
                "id=" + id +
                ", nomBassin='" + nomBassin + '\'' +
                ", tailleMax=" + tailleMax +
                ", tailleUtilise=" + tailleUtilise +
                ", dernierNetoyage=" + dernierNetoyage +
                ", etatBassin=" + etatBassin +
                '}';
    }
}
