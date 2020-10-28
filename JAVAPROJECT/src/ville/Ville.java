package ville;
import graphe.Graphe;
import java.util.ArrayList;
public class Ville {
	private double taux_emission_CO2 = Integer.MAX_VALUE;  
	/*p
	 * ermet de stocker le taux d'emission au moment où il arrive à cette ville
	 * nécessaire pour notre fonction Dijikstra
	 */
	private boolean visited;
	/*
	 * Attribut nécessaire pour le bon fonctionnement de notre fonction Dijikstra
	 * permet de savoir si une ville a deja été visité par notre algorithme
	 */
	private double DistanceParcourue;
	/*
	 * permet de stocker la distance parcourue une fois arrivée à cette ville par la méthode dijikstra
	 */
	
	private String nom;
	/*
	 * représente le sommet de graphe
	 */
	private static int INCREMENTE=0;  //compteur static 
	/*
	 * représente l'identifiant de la ville
	 */
	private  int id;
	
	
	
	private ArrayList<Chemin> chemin = new ArrayList<Chemin>(); 
	/*
	 * liste de chemins liées à ma ville
	 */
	
	//constructeur
	public Ville(String nom) {
		this.nom=nom;
		visited=false;
		id=INCREMENTE;
		INCREMENTE++;
	}

	public Ville() {
		nom="Inconnnu";
		id=INCREMENTE;
		INCREMENTE++;
		
	}
	/*
	 * renvoie la copie d'une ville
	 */
	public Ville copie(Ville v){
		Ville v1=new Ville(v.getNom());
		v1.id=v.getId();
		v1.taux_emission_CO2=v.taux_emission_CO2;
		v1.visited=v.visited;
		return v1;
	}

	
	//getters
	public String getNom() {
		return nom;
	}
	public int getId() {
		return id;
	}
	 
	public boolean isVisited() {
	    return visited;
	}	 
	public ArrayList<Chemin> getChemin() {
	    return chemin;
	}
	public double getDistance() {
		return DistanceParcourue;
	}
	public double getTauxEmissionCO2(){
		return taux_emission_CO2;
	}
	
	//setters
	public void setVisited(boolean visited) {
	    this.visited = visited;
	}
	public void setChemin(ArrayList<Chemin> chemin) {
	    this.chemin = chemin;
	}
	public void setArcs1(Chemin c){
		
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setTauxEmissionCO2(double taux){
		this.taux_emission_CO2=taux;
	}
	public void setId(int id){
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "nom:"+ nom +"   id: "+id;
	}
	
	//2ème type d'affichage avec paramètre du chemin considéré pour récuperer la distance
	/*public String toString() {
		return "nom: " + nom+ " id: "+id+ taux_emission_CO2;
	}*/
	
	
	

	public boolean equals(Ville v) {
		return ((this.nom.equals(v.getNom())) && id==v.id);
	}
	
	
	

	public void setDistance(double distanceParcourue) {
		DistanceParcourue = distanceParcourue;
	}
	
	 /*
	 * méthode qui sert à récupérer la liste des villes adjacentes
	 */
	public  ArrayList<Ville> ListeVillesadjacentes(Graphe g) {
		ArrayList<Ville> liste=new ArrayList<Ville>();
		for(Chemin a: g.getChemin()) {
			if(this.equals(a.getV1())) {
				liste.add(a.getV2());
			}
			else {
				if(this.equals(a.getV2())) {
				liste.add(a.getV1());
				}
				
			}
			/*else {
				System.out.println("Erreur!! Methode ListeVillesadjacentes");
			}*/
		}
		
		
		return liste;
	}
	/*
	 * Méthode qui sert à retourner le chemin existant entre une ville et son adjacent
	 */
	public Chemin TrouveChemin(Ville v,Graphe g) {
		Chemin trouvee=null;
		for(Chemin a:g.getChemin()){
			if(a.deuxVillesPresentes(this,v)){
				trouvee= a;
			}
		}
		return trouvee;
	}
	/*
     * Méthode utile pour récupérer notre ville à mettre en paramètre pour notre fonction qui calcule le parcours 
     * en lisant en entrée le nom de la ville tapée par l'utilisateur
     */
	public Ville getVille( ArrayList<Ville> v) {
		for(Ville v1: v) {
			if (v1.getNom().contentEquals(nom)) {
               return v1;
           }
		}
           System.out.println("Erreur !!! votre ville n'est pas dans notre base de données\n");
           return null;
                   
   }
	

	
	
}