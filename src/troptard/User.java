package troptard;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public String key;
		
	@Persistent
	public Preference[] pref;
	
	@Persistent
	public Evenement[] avenir;
	
	@Persistent
	public Evenement[] moment;
	
	@Persistent
	public String mail;
	
	@Persistent
	public String nom;
	
	@Persistent
	public String prenom;
	
	@Persistent
	public int score;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Preference[] getPref() {
		return pref;
	}

	public void setPref(Preference[] pref) {
		this.pref = pref;
	}

	public String getMail() {
		return mail;
	}

	public Evenement[] getAvenir() {
		return avenir;
	}

	public void setAvenir(Evenement[] avenir) {
		this.avenir = avenir;
	}

	public Evenement[] getMoment() {
		return moment;
	}

	public void setMoment(Evenement[] moment) {
		this.moment = moment;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

	
}
