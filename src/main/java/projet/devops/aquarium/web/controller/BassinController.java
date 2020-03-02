package projet.devops.aquarium.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projet.devops.aquarium.dao.BassinDao;
import projet.devops.aquarium.model.Bassin;

import java.net.URI;
import java.util.List;

@RestController
public class BassinController {

    @Autowired
    private BassinDao bassinDao;

    //Récupérer les informations sur les bassins
    @RequestMapping(value = "/Bassins", method = RequestMethod.GET)
    public MappingJacksonValue listeBassin() {

        List<Bassin> bassins = bassinDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(bassins);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @PostMapping(value = "/Bassins")
    public ResponseEntity<Void> ajouterBassin(@RequestBody Bassin bassin) {
        Bassin bassinAdded =  bassinDao.save(bassin);
        if (bassinAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bassinAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
