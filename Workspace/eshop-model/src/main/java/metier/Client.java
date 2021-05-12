package metier;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("customer")
@PrimaryKeyJoinColumn(name="id_personne",referencedColumnName = "id")
public class Client extends Personne {
	
	private int age;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	@Embedded
	private Adresse addresse;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
	@JoinTable(name="achats",joinColumns = @JoinColumn(name="idClient"),inverseJoinColumns = @JoinColumn(name="idProduit"))
	private List<Produit> achats;
	
	
	public Client() {
	}

	public Client(String nom,String prenom,int age, LocalDate dateNaissance, Adresse addresse) {
		super(prenom,nom);
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.addresse = addresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAddresse() {
		return addresse;
	}

	public void setAddresse(Adresse addresse) {
		this.addresse = addresse;
	}

	public List<Produit> getAchats() {
		return achats;
	}

	public void setAchats(List<Produit> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", addresse=" + addresse + ", achats="
				+ achats + ", id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	

	
	
	
}
