package troptard;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Preference {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long key;
	
	
	// nom de l'event
	@Persistent
	public String name;

	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}
}
