package projet.devops.aquarium.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projet.devops.aquarium.dao.SecteurDao;
import projet.devops.aquarium.model.Secteur;

import java.net.URI;
import java.util.List;

@RestController
public class SecteurController {

    @Autowired
    private SecteurDao secteurDao;

    //Récupérer les informations sur les bassins
    @RequestMapping(value = "/Secteurs", method = RequestMethod.GET)
    public MappingJacksonValue listeSecteur() {

        List<Secteur> secteurs = secteurDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(secteurs);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @PostMapping(value = "/Secteurs")
    public ResponseEntity<Void> ajouterSecteur(@RequestBody Secteur secteur) {
        Secteur secteurAdded =  secteurDao.save(secteur);
        if (secteurAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(secteurAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
