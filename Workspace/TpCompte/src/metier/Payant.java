package metier;

public class Payant extends Compte {

	private double decouvert;

	public Payant(double solde, Carte carte,double decouvert) {
		super(solde-50, carte, 1);
		this.decouvert = (decouvert<0) ?decouvert*-1 : decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = (decouvert<0) ?decouvert*-1 : decouvert;
	}

	
	@Override
	public boolean retraitOk(double montant) {
		if(solde+decouvert-montant-taxe>=0){return true;}
		else
		{
			return false;
		}
	}

	@Override
	public boolean versementOk(double montant) {
		if(solde+decouvert+montant-taxe>=0){return true;}
		else
		{
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "Payant [decouvert=" + decouvert + ", code=" + code + ", solde=" + solde + ", carte=" + carte + ", taxe="
				+ taxe + "]";
	}

	
	

	
	
}
