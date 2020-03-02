package projet.devops.aquarium.dao;

import projet.devops.aquarium.model.Bassin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BassinDao extends JpaRepository<Bassin, Integer> {

}