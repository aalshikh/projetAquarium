package projet.devops.aquarium.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.devops.aquarium.model.Animalbook;


@Repository
public interface AnimalbookDao extends JpaRepository<Animalbook, Integer> {

}