package eshop.metier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	//@Column(nullable=true)
	private Integer numero;
	private String voie;
	private String cp;
	private String ville;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(Integer numero, String voie, String cp, String ville) {
		this.numero = numero;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", cp=" + cp + ", ville=" + ville + "]";
	}
	
	
	
	
	

}
