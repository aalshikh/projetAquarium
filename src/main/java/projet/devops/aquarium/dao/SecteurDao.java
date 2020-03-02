package projet.devops.aquarium.dao;

import projet.devops.aquarium.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Integer> {

}