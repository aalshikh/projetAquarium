package projet.devops.aquarium.dao;


import projet.devops.aquarium.model.Animalbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalbookDao extends JpaRepository<Animalbook, Integer> {

}