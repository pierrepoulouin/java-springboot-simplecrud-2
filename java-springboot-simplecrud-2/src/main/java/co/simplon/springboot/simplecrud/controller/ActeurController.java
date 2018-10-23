package co.simplon.springboot.simplecrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.springboot.simplecrud.model.Acteur;

import co.simplon.springboot.simplecrud.repository.ActeurRepository;


@RestController
@RequestMapping("/api")
public class ActeurController {
	@Autowired
	ActeurRepository repository;
	
	@CrossOrigin
	@GetMapping("/acteur")
	List<Acteur> getAllActeur(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/acteur/{id_acteur}")
	ResponseEntity<Acteur> getActeurById(@PathVariable(value="id_acteur") long id) {
	    Acteur acteur = repository.findOne(id);
	    if(acteur == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(acteur);
	}
	
	@CrossOrigin
	@PostMapping("/acteur")
	Acteur addActeur(@Valid @RequestBody Acteur people){
		return repository.save(people);
	}
	
	@CrossOrigin
	@PutMapping("/acteur/{id_acteur}")
	ResponseEntity<Acteur> updateActeur(@PathVariable(value="id_acteur") long id, @Valid @RequestBody Acteur acteur){
		Acteur acteurToUpdate = repository.findOne(id);
		if(acteurToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		acteurToUpdate.setFirstname(acteur.getFirstname());
		acteurToUpdate.setName(acteur.getName());
		
		// Update all other not null attributes
		if(acteur.getAddress() != null)
			acteurToUpdate.setAddress(acteur.getAddress());
		
		if(acteur.getPhone() != null)
			acteurToUpdate.setPhone(acteur.getPhone());
		
		if(acteur.getEmail() != null)
			acteurToUpdate.setEmail(acteur.getEmail());
		
		Acteur updatedActeur = repository.save(acteurToUpdate);
		return ResponseEntity.ok(updatedActeur);
	}
	
	@CrossOrigin
	@DeleteMapping("/acteur/{id_acteur}")
	ResponseEntity<Acteur> deleteActeur(@PathVariable(value="id_acteur") long id){
		Acteur acteur = repository.findOne(id);
		if(acteur == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(acteur);
		return ResponseEntity.ok().build();
	}
}
