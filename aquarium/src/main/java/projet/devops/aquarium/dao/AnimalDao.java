package projet.devops.aquarium.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.devops.aquarium.model.Animal;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Integer> {
    public Animal findById(int id);

    //public void delete(int id);
}