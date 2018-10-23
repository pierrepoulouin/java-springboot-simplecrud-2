package co.simplon.springboot.simplecrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_film;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String year;
	
	int rate;
	@ManyToOne
	@JoinColumn(name= "ref_acteur", table = "film")
	private Acteur refActeur;

	public long getId_film() {
		return id_film;
	}

	public void setId_film(long id_film) {
		this.id_film = id_film;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public Acteur getRefActeur() {
		return refActeur;
	}

	public void setRefActeur(Acteur refActeur) {
		this.refActeur = refActeur;
	}

	
}

		