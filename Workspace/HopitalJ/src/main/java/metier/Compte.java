package metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity//Obligatoire
@Table(name="account")//Opt

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte")//Opt
public abstract class Compte {

	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Opt
	protected int id;

	@Column(name="log", nullable = false,length = 25)//length=50 == columnDefinition="VARCHAR(50)"
	protected String login;
	
	@Column(name="pass")
	protected String password;
	
	
	public Compte() {
	}

	public Compte(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
