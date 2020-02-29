package projet.devops.aquarium.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projet.devops.aquarium.dao.AnimalDao;
import projet.devops.aquarium.model.Animal;

import java.net.URI;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalDao animalDao;

    //Récupérer la liste des animaux
    @RequestMapping(value = "/Animals", method = RequestMethod.GET)
    public MappingJacksonValue listeAnimals() {

        List<Animal> animals = animalDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(animals);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @GetMapping(value="/Animals/{id}")
    public Animal afficherUnAnimal(@PathVariable int id) {
        return animalDao.findById(id);
    }

    @PostMapping(value = "/Animals")
    public ResponseEntity<Void> ajouterAnimal(@RequestBody Animal animal) {
        Animal animalAdded =  animalDao.save(animal);
        if (animalAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(animalAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

   /* @DeleteMapping (value = "/Animals/{id}")
    public void supprimerAnimal(@PathVariable int id) {
        animalDao.delete(id);
    }

    */
}
