package vehicule;

/*
 * Classe mère de premier niveau dans notre héritage
 */
public  abstract class Vehicule {

	private static int id_Generator=0;
	protected final int id;  
	/*
	 * identifiant unique pour chaque véhicule
	*/
	protected final String type;  
	/*
	 * (essence,electrique,gasoil
	 */
	protected double littre_consomme;
	/*
	 * la quantité d'essence qu'elle consomme en parcourant 100 km // l/km
	 */
	
	
	public Vehicule(String type, double littre_consomme) {
		this.type=type;
		id=id_Generator;
		id_Generator++;
		this.littre_consomme=littre_consomme;
	}


	
	public double getLittre_consomme() {
		return littre_consomme;
	}

	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String toString() {
		return "identifiant:"+id+" type du vehicule: "+type;
	}

	public void setLittreConsomme(double littre){
		this.littre_consomme=littre;
	}
	public abstract double calculerEmission();
	/*
	 * depends du type du véhicule, du poids de l'arrête, de la distance du chemin,durée, vitesse du véhicule ( entre autre le type du chemin ),nombre de personne
	 */
	
}
