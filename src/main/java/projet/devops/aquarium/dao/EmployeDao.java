package projet.devops.aquarium.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.devops.aquarium.model.Animal;
import projet.devops.aquarium.model.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {
    public Employe findById(int id);

    Employe findByPseudo(String pseudo);
}