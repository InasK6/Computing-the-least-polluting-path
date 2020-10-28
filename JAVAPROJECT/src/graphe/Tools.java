package graphe;

import java.util.ArrayList;


import vehicule.Vehicule;
import ville.Ville;
import ville.Chemin;



public class Tools {
	  public static int getIndice(ArrayList<Ville> ville,int id){ 
		  /*
		   * elle retourne l'indice de la ville d'identifiant id dans la liste des villes passée en paramètre
		   */
		  int indice=-1;
		  for(int i=0;i<ville.size();i++){
			  if(ville.get(i).getId()==id){
				  indice=i;
			  }
		  }
		  return indice;
	  }
	  public static Chemin[] copie(Chemin[] ch){ 
		  /*
		   * retourne la copie de la liste des chemins passés en paramètre
		   */
		  Chemin[] tab=new Chemin[ch.length];
		  for(int i=0;i<ch.length;i++){
			  tab[i]=ch[i].copie(ch[i]);
		  }
		  return tab;
	  }
	  public static ArrayList<Chemin> copieArc(ArrayList<Chemin> ch){ 
		  /*
		   * retourne la copie de "ArrayList<Chemin>" passé en paramètre
		   */
		  ArrayList <Chemin> tab=new ArrayList<Chemin>();
		  for(int i=0;i<ch.size();i++){
			  tab.add(ch.get(i).copie(ch.get(i)));
		  }
		  return tab;
		  
	  }
	 
	  public static ArrayList<Ville> copie(ArrayList<Ville> vil){ 
		  /*
		   * renvoie la copie des chemins passés en param
		   */
		  ArrayList <Ville> tab=new ArrayList<Ville>();
		  for(int i=0;i<vil.size();i++){
			  tab.add(vil.get(i).copie(vil.get(i)));
		  }
		  return tab;
		  
	  }
	  
	
	  /*
	   * printResult:  affiche le resultat de la fonction dijkstra. Elle parcourt tous les noeuds du 
	     graphe et affiche le plus court chemin pour atteindre ce sommet
	   */
	  public static void printResultDistance(Graphe g, Ville source){	
		
	    for (int i = 0; i < g.getVille().size(); i++) {
	    	System.out.println("The shortest distance from "+source.getNom()+" to " + g.getVille().get(i).getNom() + " is " +g.getVille().get(i).getTauxEmissionCO2() +"km  en emettant "+String.format("%.1f",g.getVille().get(i).getDistance())+" g" );
	      
	    }
	  }
	  /*
	   * printResult:  affiche le resultat de la fonction dijkstra. Elle parcourt tous les noeuds du 
	     graphe et affiche le  chemin le moins polluant pour atteindre ce sommet
	   */
	  public static void printResultCO2(Graphe g,Ville source ){ //soit français soit anglais 
		    for (int i = 0; i < g.getVille().size(); i++) {
		    	System.out.println("The minimum rate of CO2 issued from "+source.getNom()+" to " + g.getVille().get(i).getNom() + " is " + String.format("%.1f",g.getVille().get(i).getTauxEmissionCO2())+" g en parcourant:  "+ g.getVille().get(i).getDistance()+"  km");		      
		    }
	  }
	  
	  /*
	   * Compare les deux fonctions dijkstra c'est à dire compare les resultats retournés par printResultCO2 et printResultDistance
	   */
	  public static void printResult(Graphe g1,Graphe g2,Ville source ){
		    for (int i = 0; i < g1.getVille().size(); i++) {
		    	System.out.println("The minimum rate of CO2 issued from "+source.getNom()+" to " + g1.getVille().get(i).getNom() + " is " + String.format("%.1f",g1.getVille().get(i).getTauxEmissionCO2())+" g en parcourant :  "+ g1.getVille().get(i).getDistance()+"  km");	
		    	System.out.println("The shortest distance from "+source.getNom()+" to " + g2.getVille().get(i).getNom() + " is " +g2.getVille().get(i).getTauxEmissionCO2() +"km  en emettant "+String.format("%.1f",g2.getVille().get(i).getDistance())+" g" );
		    	System.out.println("\n");
		    }
	  }
	
	  /*
	   * getTauxCO2Minimum: selectionne dans le graphe le sommet possédant le plus faible poids
	   */
	  public static int getTauxCO2Minimum(Graphe g){
	    int Index = 0;
	    double IndexTaux =Integer.MAX_VALUE;
	 
	    for (int i = 0; i < g.getVille().size(); i++) {
	      double currentTaux = g.getVille().get(i).getTauxEmissionCO2();
	 
	      if (!(g.getVille().get(i).isVisited()) && currentTaux < IndexTaux) {
	        IndexTaux =currentTaux;
	        Index = i;
	      }
	    }
	 
	    return Index;
	  }
	
	 /*
		 * On fait un affichage de toutes les villes et tout les chemins de notre environnement
		 */
		public static void Graphe_affichage(Graphe g) {
			System.out.println("informations sur notre graphe\n");
			System.out.println("Sommets du graphe: les Villes\n");
			for(Ville v :g.getVille()) {
				String s=v+" Villes adjacentes : [ ";
				for( Chemin c: v.getChemin() ) {
					if(v.equals(c.getV1())) {
						s+=c.getV2().getNom();
						s+=" , ";
					}
					if(v.equals(c.getV2())) {
						s+=c.getV1().getNom();
						s+=" , ";
					}
				}
				s+=" ]";
				System.out.println(s+"\n");
			}
			
			
			System.out.println("\n");
			System.out.println("Arrêtes de notre graphe: Chemins \n");
			for(Chemin c : g.getChemin()) {
				System.out.println(c);
				System.out.println("\n");
			}
			
		}
	 public static void retourParcours(Graphe g,Ville source,Ville arrivee, Vehicule v){
		 /*
		  * affiche le parcours retournée par la fonction dijkstra 
		  * 		  */
		 
		 	Graphe r=g.copie(g);
			ArrayList <Ville> passage=AffichageParcourt.calculeChemin(r,source,arrivee,v);
			ArrayList<Chemin> chemin=new ArrayList<Chemin> ();
			//pour récuperer les chemin à partir des villes
			System.out.println("/n");
			//System.out.println("pour aller de "+source.getNom()+" à "+arrivee.getNom() +" en minimisant le taux d'émission  de CO2:");
			for(int i=passage.size()-1;i>0;i--){
				for(Chemin a:g.getChemin()){
					if(a.deuxVillesPresentes(passage.get(i), passage.get(i-1))){
						chemin.add(a);
						System.out.println(a.toString());
					}
				}
			}
		 
	 }	
	 /*
      * Méthode utile pour récupérer notre ville à mettre en paramètre pour notre fonction qui calcule le parcours 
      * en lisant en entrée le nom de la ville tapée par l'utilisateur
      */
	 public static Ville getVille(String nom, ArrayList<Ville> v) {
			for(Ville v1: v) {
				if (v1.getNom().contentEquals(nom)) {
	               return v1;
	           }
			}
	           System.out.println("Erreur !!! votre ville n'est pas dans notre base de données\n");
	           return null;
	                   
	   }
	 

}
