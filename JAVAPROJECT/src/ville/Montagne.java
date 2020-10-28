package ville;

/*
 * Classe fille de Chemin
 */
public class Montagne extends Chemin {
	
	
	/*
	 * le poids de l'arrête aide à définir la quantité de gaz toxiques émise entre deux villes
	 */
	
	
	private static final double MONTAGNE=0.8; 
	/*   
	    * Selon https://www.futura-sciences.com/planete/questions-reponses/pollution-reduire-vitesse-voiture-permet-il-vraiment-reduire-pollution-7417/
	    * de façon générale la réduction de la vitesse d'un véhicule contribue à diminuer son taux d'émission de gaz toxiques mais cet impact est surtout ressenti sur les voies les plus rapides
	    * avec une baisse allant jusqu'à 20%
	    * On suppose dans notre programme que le conducteur roule avec la vitesse adaptée ( 1ere, 2eme, 3eme ...) pour ne pas traiter les cas tel que le fait qu'une voiture roulant à la 5eme vitesse à 50km/h consomme plus que celle qui
	    * roule en 3eme 
	    * C'est pour ça qu'on décide de prendre comme base de calcul l'auto-route ou le taux d'émission est le plus grand ( étant donné la vitesse ) et établir des pourcentage pour le reste:
	    * 80% pour la route nationale et 60% pour la route en montagne. Sauf qu'il faut aussi prendre en compte le fait qu'une montée pousse le moteur à fournir plus d'efforts et donc emmetre 
	    * de gaz toxique c'est pur ça qu'on a décidé d la mettre à 90% par rapport à l'emission sur auto-route
	    */
	
	public Montagne(Ville v1, Ville v2,  double distance) {
		super(v1,v2,distance);
		poids=MONTAGNE*distance;
		
	}

@Override 
	
	public String toString() {
		return "Montagne "+ super.toString();
	}
	public boolean equals(Chemin a) {
		if ( a==null) return false;
		if (this==a) return true;
		if (getClass()!=a.getClass()) return false;
		Montagne ar=(Montagne) a;
		return super.equals(ar);
	}

	

}