package ville;

/*
 * Classe fille de Chemin
 * Selon l'article :
 * https://www.actu-environnement.com/ae/news/340.php4
 * j'ai pu établir des pourcentages par rapport à l'émission en comparaison entre une auto-route, une route nationale et une route de montagne
 * Ces différences sont liées aux changements de vitesses dans ces différents type de chemins
 * approximativement, le taux d'emission globale diminue en diminuant la vitesse de 10km/h
 * L'auto-route ayant la plus grande vitesse
 * Je prend comme base la route nationale 
 * Je choisis de diminuer de 20% le taux d'emission d'un type de route à un autre sachant qu'il peut y avoir des critères négligés
 */
public class Autoroute extends Chemin{
	
	
	private static final double AUTOROUTE=1.2;
	/*
	 * le poids de l'arrête aide à définir la quantité de gaz toxiques émise entre deux villes
	 */
	public Autoroute(Ville v1, Ville v2,  double distance) {
		super(v1,v2,distance);
		poids=AUTOROUTE*distance;
	}
	
	
	@Override 
	
	public String toString() {
		return "Auto-route "+ super.toString();
	}
	public boolean equals(Chemin a) {
		if ( a==null) return false;
		if (this==a) return true;
		if (getClass()!=a.getClass()) return false;
		Autoroute ar=(Autoroute) a;
		return super.equals(ar);
	}
	

}
