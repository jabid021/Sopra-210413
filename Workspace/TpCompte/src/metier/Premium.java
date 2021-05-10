package metier;

public class Premium extends Compte {

	public Premium(double solde, Carte carte) {
		super(solde-150, carte, 0);
	}

	@Override
	public boolean retraitOk(double montant) {
		return true;
	}

	@Override
	public boolean versementOk(double montant) {
		return true;
	}

	@Override
	public String toString() {
		return "Premium [code=" + code + ", solde=" + solde + ", carte=" + carte + ", taxe=" + taxe + "]";
	}

	
	
}
