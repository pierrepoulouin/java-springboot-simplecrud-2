package co.simplon.springboot.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.simplecrud.model.Acteur;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

}