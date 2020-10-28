package ville;

/*
 * Classe fille de Chemin
 */

public class RouteNationale extends Chemin{
private static final double RN=1;
/*
 * le poids de l'arrête aide à définir la quantité de gaz toxiques émise entre deux villes
 */
public RouteNationale(Ville v1, Ville v2,  double distance) {
	super(v1,v2,distance);
	poids=RN* distance;
	
}

@Override 

public String toString() {
	return "Route nationale "+ super.toString();
}

public boolean equals(Chemin a) {
	if ( a==null) return false;
	if (this==a) return true;
	if (getClass()!=a.getClass()) return false;
	RouteNationale ar=(RouteNationale) a;
	return super.equals(ar);
}



}