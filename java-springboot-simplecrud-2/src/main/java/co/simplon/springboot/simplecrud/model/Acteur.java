package co.simplon.springboot.simplecrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "acteur")
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_acteur;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String name;
	
	private String address;
	
	@Email
	private String email;
	
	@Pattern(regexp="^\\+?\\d+$")
	private String phone;

	

	public long getId_acteur() {
		return id_acteur;
	}

	public void setId_acteur(long id_acteur) {
		this.id_acteur = id_acteur;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
	