package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("secretaire")//opt
public class Secretaire extends Compte{

	private String ancien;
	
	public Secretaire() {
		super();
	}

	public Secretaire(int id, String login, String password) {
		super(id, login, password);
	}

	
	public String getAncien() {
		return ancien;
	}

	public void setAncien(String ancien) {
		this.ancien = ancien;
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	

	
}
