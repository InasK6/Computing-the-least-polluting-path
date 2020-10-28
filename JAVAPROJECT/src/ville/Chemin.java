package ville;
/*
 * classe représentant les arrêtes dans notre graphe
 * un ensemble de chemin forme un parcours: c'est ce qu'on cherche à calculer dans notre programme
 */

/*
 * le chemin peut être une Autoroute, une route nationale ou un chemin de montagne
 * Le taux d'émission des gaz diffère selon le type de chemin parcouru car la vitesse
 * et le temps varient et sont les principaux influenceurs sur le taux d'émission
*/
public  abstract class Chemin {

	
	
	
	protected  Ville v1;
	/*
	 * représente un sommet de l'arrête
	 */
	
	protected double poids;
	/* 
	 * on a besoin de retourner sa valeur même si les méthodes appropriées seront définit dans les classes filles
	 * il est necessaire de l'avoir dans la classe mère pour pouvoir le manipuler dans d'autres fonctions sans savoir le types exacte du véhicule
	 * c'est à dire la classe fille spécifique. On récupère le poids voulu par héritage.
	 */
	protected Ville v2;
	/*
	 * représente un deuxième sommet de l'arrête
	 * Notre graphe n'est pas orienté, c'est pour ça qu'on ne parle pas ici de sommet incident...
	 */
	
	protected double distance;
	/*
	 * représente la distance en km qui sépare les deux villes, elle ne sera pas calculé 
	 * mais dans notre base de données
	 * On la récuperera de Google maps a chaque instaciation d'un chemin
	 */
	
	
	public Chemin(Ville v1, Ville v2,  double distance) { //je construit un arc entre deux villes
		this.v1=v1;
		this.v2=v2;
		this.distance=distance;
	
		
	}
   
    public Chemin  copie(Chemin c){
    	
    	if (c instanceof Autoroute) {
    		 return new Autoroute(c.getV1().copie(c.getV1()),c.getV2().copie(c.getV2()),c.getDistance());
    	}
    	if (c instanceof Montagne) {
    		return new Montagne(c.getV1().copie(c.getV1()),c.getV2().copie(c.getV2()),c.getDistance());
    	}
    	if (c instanceof RouteNationale) {
    		  return new RouteNationale(c.getV1().copie(c.getV1()),c.getV2().copie(c.getV2()),c.getDistance());
    	}
    	System.out.println("Type non cohérent");
    	return null;
         
    }
	
	@Override
	public String toString() {
		return   "("+v1.getNom() +"----"+distance+" km"+"----"+v2.getNom() +")   " ;
		
	}
	
	//getters
	public  Ville getV1() {
		return v1;
	}
	public  Ville getV2() {
		return v2;
	}
	public double getDistance() {
		return distance;
	}

	//setters
	public void setV1(Ville v1) {
		this.v1=v1;
	}
	public void setV2(Ville v2) {
		this.v2=v2;
	}
	public void setDistance(double distance) {
		this.distance=distance;
	}
	
	
	
	/*
	 * permet de récuperer l'indice de l'adjacent selon un chemin donné de notre ville courante
	 */
	public int getNeighbourIndex(int indice_courant) {
	   if (this.v1.getId() == indice_courant) {
	     return this.v2.getId();
	   } 
	   else {
	      return this.v1.getId();
	   }
	}
	/*
	 * verifie si la ville v est l'un des sommets de notre chemin
	 */
	public boolean villePresente(Ville v){  
		if((v.getId()==v1.getId())||(v.getId()==v2.getId())){
			return true;
		}
		return false;
	}
	/*
	 * verifie si les deux villes sont les memes que celles du chemin
	 */
	public boolean deuxVillesPresentes(Ville v1,Ville v2){ 
		
		if((this.v1.equals(v1) && this.v2.equals(v2))|| (this.v1.equals(v2) && this.v2.equals(v1))){
			return true;
		}
		return false;
	}
	
	public boolean equals(Chemin c) {
		return ( ((v1.equals(c.getV1()) && v2.equals(c.getV2())) || (v1.equals(c.getV2()) && v2.equals(c.getV1()))) && distance==c.getDistance() );
		
	}
	public double getPoids() {
		return poids;
	}
	/*
	 * setters pour le poids à utiliser uniquement dans le cas ou il y a un problème sur le chemin ( par exemple un accident ce qui causerait des ralentissements...
	 */
	public void setPoids(double p) {
		poids=p;
	}
	
}