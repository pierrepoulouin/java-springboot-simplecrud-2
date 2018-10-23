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

import co.simplon.springboot.simplecrud.model.Film;


import co.simplon.springboot.simplecrud.repository.FilmRepository;

@RestController
@RequestMapping("/api")
public class FilmController {
	@Autowired
	FilmRepository repository;

	@CrossOrigin
	@GetMapping("/film")
	List<Film> getAllFilm() {
		return repository.findAll();
	}

	@CrossOrigin
	@GetMapping("/film/{id_film}")
	ResponseEntity<Film> getFilmById(@PathVariable(value = "id_film") long id) {
		Film film = repository.findOne(id);
		if (film == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(film);
	}

	@CrossOrigin
	@PostMapping("/film")
	Film addFilm(@Valid @RequestBody Film film) {
		return repository.save(film);
	}

	@CrossOrigin
	@PutMapping("/film/update/{id_film}")
	ResponseEntity<Film> updateFilm(@PathVariable(value = "id_film") long id, @Valid @RequestBody Film film) {
		Film filmToUpdate = repository.findOne(id);
		if (filmToUpdate == null)
			return ResponseEntity.notFound().build();

		// Update the mandatory attributes

		filmToUpdate.setName(film.getName());
		filmToUpdate.setYear(film.getYear());
		filmToUpdate.setRate(film.getRate());

		// Update all other not null attributes
		if(film.getName() != null)
			filmToUpdate.setName(film.getName());
		if(film.getYear() != null)
			filmToUpdate.setYear(film.getYear());
		if(film.getRate() != 0)
			filmToUpdate.setRate(film.getRate());

		Film updatedFilm = repository.save(filmToUpdate);
		return ResponseEntity.ok(updatedFilm);
	}

	@CrossOrigin
	@DeleteMapping("/film/delete/{id_film}")
	ResponseEntity<Film> deletefilm(@PathVariable(value = "id_film") long id) {
		Film film = repository.findOne(id);
		if (film == null)
			return ResponseEntity.notFound().build();

		repository.delete(film);
		return ResponseEntity.ok().build();
	}
}
