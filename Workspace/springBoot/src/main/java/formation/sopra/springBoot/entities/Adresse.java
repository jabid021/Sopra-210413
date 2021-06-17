package formation.sopra.springBoot.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import formation.sopra.springBoot.entities.views.Views;

@Embeddable
public class Adresse {
	@JsonView(Views.Common.class)
	@NotNull
	private Integer numero;
	@JsonView(Views.Common.class)
	@Column(name = "rue", length = 200)
	@NotEmpty
	private String rue;
	@JsonView(Views.Common.class)
	@Column(name = "code_postal", length = 20)
	@NotEmpty
	private String codePostal;
	@JsonView(Views.Common.class)
	@Column(name = "ville", length = 150)
	@NotEmpty
	private String ville;

	public Adresse() {

	}

	public Adresse(Integer numero, String rue, String codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
