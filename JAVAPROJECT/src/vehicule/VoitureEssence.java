package vehicule;



/*	  	Un véhicule essence est la dénomination d'une voiture qui a un moteur qui utilise l'essence comme carburant et qui l'allumage se fais par étincelles électriques.
 */
public class VoitureEssence extends Voiture {
	protected String type_Essence;
	public VoitureEssence(double littre_consomme) {
		super(littre_consomme);
		this.type_Essence="Essence";
		
	}
	@Override
	public String getType() {
		return type_Essence;
	}
	@Override
	public String toString() {
		return super.toString()+"    à essence";
	}
	@Override
	public double calculerEmission(){ // la distance doit etre en Km
		double emission_par_km;
			/*
			 *  est la masse du dioxyde de carbone émise par un véhicule à essance en parcourant 1km
			 */
			emission_par_km=(2392*this.getLittre_consomme())/100; 
			return emission_par_km; 
			/*
			 * le resultat est en g
			 */
			/*
			  Justifier la valeur 2392
			 * 1 litre d'essence pèse 750 grammes. L'essence est composée à 87% de carbone (C), ce qui correspond à 652 g de C par litre d'essence. Pour brûler ce C en CO2, 1740 g d'oxygène sont nécessaires. La somme nous donne donc 652 + 1740 = 2392 g de CO2 par litre d'essence.
		*/
	}

}
