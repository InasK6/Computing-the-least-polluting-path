package vehicule;
/*
 * Classe fille de Véhicule et classe mère de deuxième niveau
 * Elle aura pour classes filles les principaux types de véhicules existants 
 * on a des voitures qui marchent avec essence et d'autres en Diesel 
 * De façon générale, il y a deux types de voiture en essence: CNG et PLG 
 * qui reprèsentent:
 */

public class Voiture extends Vehicule {
	
	
	public Voiture(double littre_consomme) {
		super("Voiture",littre_consomme);
		

	}
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public double calculerEmission() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
