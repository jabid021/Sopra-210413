package formation.sopra.springBoot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.views.Views;

@Entity
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 100, allocationSize = 1)
public class Utilisateur {
	@Id
	@GeneratedValue(generator = "seqUtilisateur", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@JsonView(Views.Common.class)
	@Column(name = "login", nullable = false, unique = true, length = 200)
	@NotEmpty
	private String login;
	@Column(name = "password", nullable = false, length = 200)
	// @Pattern()
	private String password;
	// les utilisateurs ont 1 role
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 50)
	private Role role;
	@OneToOne(mappedBy = "utilisateur")
	private Client client;

	public Utilisateur() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
