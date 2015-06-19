package troptard;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Evenement {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long key;
	
	
	// nom de l'event
	@Persistent
	public String name;
	@Persistent
	public String link;
	@Persistent
	public String description ;
	@Persistent
	public String categorie ;
	@Persistent
	public String image;
	@Persistent
	public String adresse ;
	@Persistent
	public String date_debut ;
	@Persistent
	public String date_fin ;
	@Persistent
	public String geolocalisation;
	@Persistent
	public User[] users;


	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Evenement(){} //must have no-arg constructor in Objectify
	
	public Long getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getGeolocalisation() {
		return geolocalisation;
	}

	public void setGeolocalisation(String geolocalisation) {
		this.geolocalisation = geolocalisation;
	}

	public void setKey(Long key) {
		this.key = key;
	}
	

}
