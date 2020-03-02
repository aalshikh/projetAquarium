package projet.devops.aquarium.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projet.devops.aquarium.dao.AnimalbookDao;
import projet.devops.aquarium.model.Animalbook;

import java.net.URI;
import java.util.List;

public class AnimalbookController {

    @Autowired
    private AnimalbookDao animalbookDao;

    //Récupérer les informations sur les especes
    @RequestMapping(value = "/Animalbooks", method = RequestMethod.GET)
    public MappingJacksonValue listeAnimalbooks() {

        List<Animalbook> animalbooks = animalbookDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(animalbooks);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @PostMapping(value = "/Animalbooks")
    public ResponseEntity<Void> ajouterAnimalbook(@RequestBody Animalbook animalbook) {
        Animalbook animalbookAdded =  animalbookDao.save(animalbook);
        if (animalbookAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(animalbookAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}