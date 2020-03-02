package projet.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Secteur {
    @Id
    @GeneratedValue
    private int id;
    private String nom;

    @OneToMany(mappedBy="secteur")
    private Set<Bassin> bassins;

    public Secteur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Secteur() {
    }

    public int getId() { return id; }

    public String getNom() { return nom; }

    public void setId(int id) { this.id = id; }

    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
