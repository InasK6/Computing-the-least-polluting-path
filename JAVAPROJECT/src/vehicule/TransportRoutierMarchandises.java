package vehicule;

/*
 * Classe fille de Véhicule et classe mère de deuxième niveau
 */
public class TransportRoutierMarchandises extends Vehicule {
	private double poids_marchandise;
	/*
	 * cette attribut est necessaire car il inflût sur le taux dd'émission
	 */
	private double facteur_emission; 
	/*
	* facteur d’émission du gazole routier à la pompe en kg CO2  ℓ  
	* nécessaire pour le calcul de notre taux d'émission
	*niveau 1 ce facteur=3.07kg de co2/l
	 */
	private String type_diesel;
	/*
	 * Les transports de marchandises sont tous des véhicules à gasoil	 */
	public TransportRoutierMarchandises( double poids,double littre_consomme) {
		super("Transport_De_Marchandises",littre_consomme);
		poids_marchandise=poids;
		type_diesel="Diesel";
		facteur_emission=3.07;//en kg
	}
	@Override
	public String getType() {
		return type_diesel;
	}
	public double getFacteurEmission() {
		return facteur_emission;
	}
	public String toString() {
		return super.toString()+ "  transporte  "+poids_marchandise+"  tonnes"+ "   vehicule à gasoil:  "+type_diesel;
	}
	@Override
	public double calculerEmission(){
		
		return ((this.getLittre_consomme()/100)*facteur_emission*poids_marchandise)/1.8;
		//1.8=est la valeur de niveau 1 pour le nombre d’unités transportées correspondant au tonnage moyen transporté dans ce type de véhicule en intégrant les trajets à vide 
		
	}

}
