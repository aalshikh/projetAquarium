package projet.devops.aquarium.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.devops.aquarium.model.Bassin;

@Repository
public interface BassinDao extends JpaRepository<Bassin, Integer> {

}