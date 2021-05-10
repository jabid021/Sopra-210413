package test;

import metier.Carte;
import metier.Compte;
import metier.Payant;
import metier.Premium;
import metier.Simple;

public class Test {

	public static void main(String[] args) {

        Simple s1 = new Simple(150,Carte.CB);
        Payant p1 = new Payant(200,Carte.Visa,200);
        Premium pr1 = new Premium(300,Carte.MC);

        s1.versement(3);
        p1.retrait(500);
        pr1.transfert(250,s1);
        
        System.out.println(Compte.getTotalTaxes());
        System.out.println(Compte.getNbTransac());
        
        System.out.println(Compte.getBanque());

       
	}

}
