package vehicule;

/*
 *  Le GPL en français ou LPG  en anglais est utilisé comme carburant pour voiture, il est l'une des utilisations du gaz de pétrole liquéfié issu d'un mélange d'hydrocarbures légers stocké à l'état liquide et du raffinage du pétrole.
 */
public class VoitureEssenceLPG extends VoitureEssence {
	protected String type_lgp;
	public VoitureEssenceLPG(double littre_consomme) {
		super(littre_consomme);
		type_lgp="LGP";
	}
	public String toString() {
		return super.toString()+" LGP";
	}
	public double calculerEmission(){ // la distance doit etre en Km(celle de l'arc)
		double emission_par_km;
			/*
			 *  est la masse du dioxyde de carbone émise par un véhicule à essance en parcourant 1km
			 */
			emission_par_km=(1665*this.getLittre_consomme())/100; 
			return emission_par_km;
		
	}
	/*  Justification du chiffre 1665
	 * 1 litre de LPG pèse 550 grammes. Le LPG est composé à 82.5% de carbone (C), ce qui correspond à 454 g de C par litre de LPG. Pour brûler ce C en CO2, 1211 g d'oxygène sont nécessaires. La somme nous donne donc 454 + 1211 = 1665 g de CO2 par litre de LPG.
	 */

}
