package eshop.metier;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
//@DiscriminatorValue("customer")
//@PrimaryKeyJoinColumn(name="id_personne",referencedColumnName = "id")
public class Client extends Personne {
	@Transient
	private int age;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero",column = @Column(name="numero_client")),
		@AttributeOverride(name="voie",column =@Column(name="rue_client",length = 250) ),
		@AttributeOverride(name="cp",column = @Column(name="cp_client",length = 10)),
		@AttributeOverride(name="ville",column = @Column(name="ville_client",length = 200))
	})
	private Adresse addresse;
	@OneToMany(mappedBy = "id.client")
	private List<Achat> achats;
	
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

	

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", addresse=" + addresse  + ", id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	

	
	
	
}
