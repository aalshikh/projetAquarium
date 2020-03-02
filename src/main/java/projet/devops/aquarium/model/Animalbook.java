package projet.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animalbook {

    @Id
    @GeneratedValue
    private int id;
    private String espece;
    private float poidsMin;
    private float poidsMax;
    private int ageMoyen;
    private int ageMax;
    private String description;
    //private BLOB image;
    private float tailleMin;
    private float tailleMax;
    private float tailleMoyenne;
    private int niveauMenace;
    private String regimeAlimentaire;


    public Animalbook(int id, String espece, float poidsMin, float poidsMax, int ageMoyen, int ageMax, String description, float tailleMin, float tailleMax, float tailleMoyenne, int niveauMenace, String regimeAlimentaire) {
        this.id = id;
        this.espece = espece;
        this.poidsMin = poidsMin;
        this.poidsMax = poidsMax;
        this.ageMoyen = ageMoyen;
        this.ageMax = ageMax;
        this.description = description;
        this.tailleMin = tailleMin;
        this.tailleMax = tailleMax;
        this.tailleMoyenne = tailleMoyenne;
        this.niveauMenace = niveauMenace;
        this.regimeAlimentaire = regimeAlimentaire;
    }

    public Animalbook(){
    }

    public int getId() {
        return id;
    }

    public String getEspece() { return espece; }

    public float getPoidsMin() { return poidsMin; }

    public float getPoidsMax() { return poidsMax; }

    public int getAgeMoyen() { return ageMoyen; }

    public int getAgeMax() { return ageMax; }

    public String getDescription() { return description; }

    public float getTailleMin() { return tailleMin; }

    public float getTailleMax() { return tailleMax; }

    public float getTailleMoyenne() { return tailleMoyenne; }

    public int getNiveauMenace() { return niveauMenace; }

    public String getRegimeAlimentaire() { return regimeAlimentaire; }

    public void setId(int id) { this.id = id; }

    public void setEspece(String espece) { this.espece = espece; }

    public void setPoidsMin(float poidsMin) { this.poidsMin = poidsMin; }

    public void setPoidsMax(float poidsMax) { this.poidsMax = poidsMax; }

    public void setAgeMoyen(int ageMoyen) { this.ageMoyen = ageMoyen; }

    public void setAgeMax(int ageMax) { this.ageMax = ageMax; }

    public void setDescription(String description) { this.description = description; }

    public void setTailleMin(float tailleMin) { this.tailleMin = tailleMin; }

    public void setTailleMax(float tailleMax) { this.tailleMax = tailleMax; }

    public void setTailleMoyenne(float tailleMoyenne) { this.tailleMoyenne = tailleMoyenne; }

    public void setNiveauMenace(int niveauMenace) { this.niveauMenace = niveauMenace; }

    public void setRegimeAlimentaire(String regimeAlimentaire) { this.regimeAlimentaire = regimeAlimentaire; }

    @Override
    public String toString() {
        return "Animalbook{" +
                "id=" + id +
                ", espece='" + espece + '\'' +
                ", poidsMin=" + poidsMin +
                ", poidsMax=" + poidsMax +
                ", ageMoyen=" + ageMoyen +
                ", ageMax=" + ageMax +
                ", description=" + description +
                ", tailleMin=" + tailleMin +
                ", tailleMax=" + tailleMax +
                ", tailleMoyenne=" + tailleMoyenne +
                ", niveauMenace=" + niveauMenace +
                ", regimeAlimentaire=" + regimeAlimentaire +
                '}';
    }

}
