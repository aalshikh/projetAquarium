package projet.devops.aquarium.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String espece;
    private char sexe;
    private String signeDistinctif;
    private String bilanSante;
    private Date dateArr;
    private Date dateDep;
    private float taille;
    private int age;
    //private int bassinAppartenance;

    @ManyToOne
    @JoinColumn
    private Bassin bassin;

    public Animal(int id, String nom, String espece, char sexe, String signeDistinctif, String bilanSante, Date dateArr, Date dateDep, float taille, int age/*, int bassinAppartenance*/) {
        this.id = id;
        this.nom = nom;
        this.espece = espece;
        this.sexe = sexe;
        this.signeDistinctif = signeDistinctif;
        this.bilanSante = bilanSante;
        this.dateArr = dateArr;
        this.dateDep = dateDep;
        this.taille = taille;
        this.age = age;
        //this.bassinAppartenance = bassinAppartenance;
    }

    //constructeur par défaut
    public Animal() {
    }


    public int getId() { return id; }

    public String getEspece() { return espece; }

    public String getNom() { return nom; }

    public char getSexe() { return sexe; }

    public String getSigneDistinctif() { return signeDistinctif; }

    public String getBilanSante() { return bilanSante; }

    public Date getDateArr() { return dateArr; }

    public Date getDateDep() { return dateDep; }

    public float getTaille() { return taille; }

    public int getAge() { return age; }

    //public int getBassinAppartenance() { return bassinAppartenance; }

    public Bassin getBassin() { return bassin; }

    public void setId(int id) { this.id = id; }

    public void setEspece(String espece) { this.espece = espece; }

    public void setNom(String nom) { this.nom = nom; }

    public void setSexe(char sexe) { this.sexe = sexe; }

    public void setSigneDistinctif(String signeDistinctif) { this.signeDistinctif = signeDistinctif; }

    public void setBilanSante(String bilanSante) { this.bilanSante = bilanSante; }

    public void setDateArr(Date dateArr) { this.dateArr = dateArr; }

    public void setDateDep(Date dateDep) { this.dateDep = dateDep; }

    public void setTaille(float taille) { this.taille = taille; }

    public void setAge(int age) { this.age = age; }

    //public void setBassinAppartenance(int bassinAppartenance) { this.bassinAppartenance = bassinAppartenance; }

    public void setBassin(Bassin bassin) { this.bassin = bassin; }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", espece=" + espece +
                ", sexe=" + sexe +
                ", signeDistinctif=" + signeDistinctif +
                ", bilanSante=" + bilanSante +
                ", dateArr=" + dateArr +
                ", dateDep=" + dateDep +
                ", taille=" + taille +
                ", age=" + age +
                //", bassinAppartenance=" + bassinAppartenance +
                '}';
    }
}
