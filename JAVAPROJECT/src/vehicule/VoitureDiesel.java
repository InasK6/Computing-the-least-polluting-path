package vehicule;
/*
  Un véhicule  diesel est la dénomination d'une voiture qui a un moteur qui utilise le gazole comme carburant et contrairement au moteur essence n'utilise pas l'allumage par étincelles électriques.
 */
public class VoitureDiesel extends Voiture{
	protected final String type_Diesel;
	/*
	 * Attributs rajouté car il caractérise cette voiture
	 */
	
	public VoitureDiesel(double littre_consomme) {
		super(littre_consomme);
		this.type_Diesel="Diesel";
		
	}
	public String getType() {
		return type_Diesel;
	}
	public String toString() {
		return super.toString()+"  à gasoil";
	}
	public double calculerEmission(){ // la distance doit etre en Km
		double emission_par_km;
		emission_par_km=(2640*this.getLittre_consomme())/100; 
		return emission_par_km; //le resultat est en g
	}
	/* Justifier la valeur 2640:
	 * 1 litre de diesel pèse 835 grammes. Le diesel est composé à 86.2% de carbone (C), ce qui correspond à 720 g de C par litre de diesel. Pour brûler ce C en CO2, 1920 g d'oxygène sont nécessaires. La somme nous donne donc 720 + 1920 = 2640 g de CO2 par litre de diesel.

	 */

}
