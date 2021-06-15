package formation.sopra.exo.model.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import formation.sopra.exo.model.Role;

@Embeddable
public class UtilisateurRoleKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "login")
	private Utilisateur utilisateur;
	private Role role;

	public UtilisateurRoleKey() {

	}

	public UtilisateurRoleKey(Utilisateur utilisateur, Role role) {
		super();
		this.utilisateur = utilisateur;
		this.role = role;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		UtilisateurRoleKey other = (UtilisateurRoleKey) obj;
		if (role != other.role)
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

}
