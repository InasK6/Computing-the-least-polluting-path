package vehicule ;



public class Bus extends Vehicule {
	private int nbPersonne;
	public Bus(double littre_consomme,int nbPersonne) {
		super("Diesel",littre_consomme);
		this.nbPersonne=nbPersonne;
	}
	
	public double calculerEmission(){ // la distance doit etre en Km
		double emission_par_km;
		if(nbPersonne<=14) {
			emission_par_km=(2640*40)/100; 
		/*
		 * 40 représente le nombre de littres consommés en parcourant 100 KM par un bus à 14 occupants
		 */
			return emission_par_km; //le resultat est en g
		}
		else {
			emission_par_km=(2640*50)/100; 
			/*
			 * 50 représente le nombre de littres consommés en parcourant 100 KM par un bus à 21 occupants
			 */
				return emission_par_km; //le resultat est en g
		}
	}
	/* Justifier la valeur 2640:
	 * 1 litre de diesel pèse 835 grammes. Le diesel est composé à 86.2% de carbone (C), ce qui correspond à 720 g de C par litre de diesel. Pour brûler ce C en CO2, 1920 g d'oxygène sont nécessaires. La somme nous donne donc 720 + 1920 = 2640 g de CO2 par litre de diesel.

	 */

}
