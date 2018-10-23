package co.simplon.springboot.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.simplecrud.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
