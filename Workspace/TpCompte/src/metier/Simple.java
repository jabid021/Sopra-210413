package metier;

public class Simple extends Compte {

	public Simple(double solde, Carte carte) {
		super(solde, carte, 5);
	}

	@Override
	public boolean retraitOk(double montant) {
		if(solde-montant-taxe>=0){return true;}
		else
		{
			return false;
		}
	}

	@Override
	public boolean versementOk(double montant) {
		if(solde+montant-taxe>=0){return true;}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Simple [code=" + code + ", solde=" + solde + ", carte=" + carte + ", taxe=" + taxe + "]";
	}

}
