package projet.devops.aquarium.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.devops.aquarium.model.Secteur;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Integer> {

}