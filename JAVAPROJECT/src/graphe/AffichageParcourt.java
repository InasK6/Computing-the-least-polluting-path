package graphe;
import java.util.ArrayList;
import vehicule.Vehicule;
import ville.Ville;
import ville.Chemin;

public class AffichageParcourt {	
	

	 /*
	  *  La fonction calculChemin génère à partir de votre position "ville source" et du lieu d'arrivé "ville d'arrivée" l'itinéaires aduéquat en prenant en compte que le parmètre "Distance"
	  *  c'est à dire  le plus court chemin
	 */

	public static ArrayList<Ville> calculeChemin(Graphe g,Ville source,Ville arrivee,Vehicule v) {
		Graphe r=g.copie(g);
		Ville copie=arrivee.copie(arrivee);						
							
		Chemin ch=null;
		int indicearrivee;
		int VoisinIndex ; 
		/*
		 * stockera l'indice du voisin dans la liste ville pour pouvoir le récuperer facilement 
		 */
		Ville tmp=null;		
		/*
		 * variable temporaire
		 */
		
		/*
		 * chemin est une variable qui stockera le chemin entre la ville arrivee et son adjacent
		 */
		Dijkstra.DijKtraShortestDistances(r,source, v);
		/*
		 * appel à la fonction dijkstra
		 */
		ArrayList <Ville>  recupereVille=new ArrayList<Ville> ();
		
		recupereVille.add(arrivee);
		/*
		 * recupereVille sert à recuperer l'itinéaire souhaité 
		 */
		ArrayList <Ville>  adjacents=new ArrayList<Ville>();
		/*
		 * recupère la liste des villes adjacentes à un certain sommet
		 */
		indicearrivee=Tools.getIndice(r.getVille(), copie.getId()); 
		for(int j=0;j<g.getNbArcs();j++) {
			copie=g.getVille().get(indicearrivee);
			 adjacents=copie.ListeVillesadjacentes(g);
			/*
			 * On récupère l'indice de la ville source dans ArrayList<Ville> du graphe (On recupère la position de la ville source dans le graphe)
			 */
			for(int i=0;i<adjacents.size();i++) {
				tmp=adjacents.get(i);
				/*if(tmp.equals(source)) {
					recupereVille.add(source);
					return recupereVille;
				}*/
				VoisinIndex=Tools.getIndice(r.getVille(),tmp.getId());
		        /*
	        	 * On récupère l'indice de la ville voisine dans le graphe
	        	 */       
				
				ch=copie.TrouveChemin(tmp,g);
					int dif=(int)((r.getVille().get(indicearrivee).getTauxEmissionCO2())-(r.getVille().get(VoisinIndex).getTauxEmissionCO2()));
					if(dif==(int)(ch.getDistance())) {
						recupereVille.add(tmp);						
						indicearrivee=VoisinIndex;						
					}
		
			}
			
		}
		
		return recupereVille;
		
	}		
	

}
