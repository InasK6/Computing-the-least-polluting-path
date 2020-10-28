package vehicule;

public class Moto extends Vehicule {
	public Moto(double littre_consomme) {
		super("Diesel", littre_consomme);
	}
	public double calculerEmission(){ // la distance doit etre en Km
		double emission_par_km;
			emission_par_km=(2640*4.5)/100; 
		/*
		 * 4.5 représente le nombre de littres consommés en parcourant 100 KM par une moto
		 */
			return emission_par_km; //le resultat est en g
	}

}
