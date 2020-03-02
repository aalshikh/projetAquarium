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
import projet.devops.aquarium.dao.EmployeDao;
import projet.devops.aquarium.model.Animal;
import projet.devops.aquarium.model.Employe;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeController {

    @Autowired
    private EmployeDao employeDao;

    //Récupérer la liste des animaux
    @RequestMapping(value = "/Employes", method = RequestMethod.GET)
    public MappingJacksonValue listeEmployes() {

        List<Employe> employes = employeDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(employes);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @GetMapping(value="/Employes/{id}")
    public Employe afficherUnEmploye(@PathVariable int id) {
        return employeDao.findById(id);
    }

    @PostMapping(value = "/Employes")
    public ResponseEntity<Void> ajouterEmploye(@RequestBody Employe employe) {
        Employe employeAdded =  employeDao.save(employe);
        if (employeAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

   @DeleteMapping (value = "/Employes/{id}")
    public void supprimerEmploye(@PathVariable int id) {
        employeDao.deleteById(id);
    }

    @GetMapping(value="/Employes/{pseudo}/{mdp}")
    public Employe afficherUnEmployeParPseudo(@PathVariable String pseudo, @PathVariable String mdp) {
        Employe e = employeDao.findByPseudo(pseudo);

        if(e==null){
            return null;
        }
        String mdpE = e.getMdp();
        if(e.getPseudo().equals(pseudo)==false){
            return null;
        }
        if(e.getMdp().equals(mdp)==false){
            return null;
        }
        return e;
    }

}
