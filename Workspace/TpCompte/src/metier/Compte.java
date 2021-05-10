package metier;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {


	protected int code;
	private static int cpt=0;
	protected double solde;
	protected Carte carte;
	protected double taxe;

	private static double totalTaxes=0;
	private static int nbTransac=0;
	private static List<Compte> banque=new ArrayList();


	public Compte(double solde, Carte carte, double taxe) {
		this.solde = solde-carte.getPrix();
		this.carte = carte;
		this.taxe = taxe;
		cpt++;
		this.code=cpt;
		
		banque.add(this);
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public static int getCpt() {
		return cpt;
	}


	public static void setCpt(int cpt) {
		Compte.cpt = cpt;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Carte getCarte() {
		return carte;
	}


	public void setCarte(Carte carte) {
		this.carte = carte;
	}


	public double getTaxe() {
		return taxe;
	}


	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}



	public abstract boolean retraitOk(double montant);
	public abstract boolean versementOk(double montant);


	public void versement(double montant) 
	{
		if(versementOk(montant))
		{
			solde+=montant-taxe;
			nbTransac++;
			totalTaxes+=taxe;
		}
	}

	public void retrait(double montant) 
	{
		if(retraitOk(montant))
		{
			solde-=(montant+taxe);
			nbTransac++;
			totalTaxes+=taxe;
		}
	}

	public void transfert(double montant,Compte c) 
	{
		if(this.retraitOk(montant) && c.versementOk(montant) ) 
		{
			this.retrait(montant);
			c.versement(montant);
		}
	}


	public static double getTotalTaxes() {
		return totalTaxes;
	}


	public static int getNbTransac() {
		return nbTransac;
	}


	public static List<Compte> getBanque() {
		return banque;
	}









}
