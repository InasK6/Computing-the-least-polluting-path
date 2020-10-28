package graphe;
import java.util.ArrayList;

import vehicule.Vehicule;
import ville.Ville;
import ville.Chemin;


public class Dijkstra implements MethodesDijkstra{

	  /*
	 * the Dijkstra algorithm !!!
	 * L'algorithme calcule le parcourt adéquat selon le poids des arretes d'un graphe.Ces poids dépendent de plusiers paramètres.
	 * Dans notre cas,le poids dépend non seulement de la distance mais aussi du taux d'émission de CO2 d'un véhicule .
	 * Dijkstra renvoie le chemin qui emet le moins de CO2 possible
	 
	 * 
	 */
	 

		public static void calculateLowerEmissionCO2(Graphe g,Ville source,Vehicule v) {
			
			int indiceSource=Tools.getIndice(g.getVille(), source.getId()); 
			/*
			 * On récupère l'indice de la ville source dans ArrayList<Ville> du graphe (On recupère la position de la ville source dans le graphe)
			 */
		    g.getVille().get(indiceSource).setTauxEmissionCO2(0);	
		    /*
		     * On initialise le taux d'émission de CO2 à 0g dans la ville de départ
		     */
		    int nextVille = indiceSource; 
		    /*
		     * nexVille récupère l'indice de la ville courante dans l'ArrayList qui stocke l'ensemble des villes du graphe
		     */
		    int idNextVille; 
		    
		    /*
		     * récupère l'identifiant de la  ville courante 
		     */
		    
		    
		    // visit every node "ville"
		    for (int i = 0; i < g.getVille().size(); i++) {
		    	idNextVille=g.getVille().get(nextVille).getId();
		    	/*
			       *  On récupère l'identifaiant de la ville courant 
			       */
		       
		    	/* loop around the edges of current node
		    	 * on parcourt toutes les villes, et pour chaque ville on determine l'ensemble des chemins possibles
		    	 */
		      ArrayList<Chemin> currentVilleArcs = new ArrayList<Chemin> ();
		      currentVilleArcs=g.getVille().get(nextVille).getChemin(); 
		      /*
	    	   * Liste des chemins adjacents à la ville courante (NextVille) qu'on récuperera à partir du graphe 
	    	   *
		      * On parcourt la liste des arcs d'une ville 
		      */
		      for (int joinedArc = 0; joinedArc < currentVilleArcs.size(); joinedArc++) {
		    	 
		    	// Oe determine la ville voisine à nextVille
		        int IdneighbourIndex = currentVilleArcs.get(joinedArc).getNeighbourIndex(idNextVille);
		        /*
	        	 * IdneighbourIndex:stocke l'identifiant de la ville voisine
	        	 */
		        int neighbourIndex=Tools.getIndice(g.getVille(),IdneighbourIndex);
		        
		        /*
	        	 * On récupère l'indice de la ville voisine dans le graphe
	        	 */       
		        //only if not visited	
		        if (!(g.getVille().get(neighbourIndex).isVisited())) {
		        	/*		        	 
		     		 * ON calcule le taux d'émission du CO2 emis pour  atteindre la ville neighbourIndex 
		     		 */	
		        	double tentative = g.getVille().get(nextVille).getTauxEmissionCO2() + (currentVilleArcs.get(joinedArc).getPoids())*v.calculerEmission();
		        	/*		        	 
		     		 * ON calcule la distance necessaire pour  atteindre la ville voisine (neighbourIndex )
		     		 */
		        	double tentativedistance= g.getVille().get(nextVille).getDistance() + (currentVilleArcs.get(joinedArc).getDistance());
		          if (tentative < ((g.getVille().get(neighbourIndex)).getTauxEmissionCO2())) {
		            (g.getVille().get(neighbourIndex)).setTauxEmissionCO2(tentative);
		            (g.getVille().get(neighbourIndex)).setDistance(tentativedistance); 
		            /*
		             * On stocke  la distance parcourue à fin d'emettre un minimum de co2
		             */
		          }
		        }
		      }
		 
		      // all neighbours checked so node visited
		      g.getVille().get(nextVille).setVisited(true);
		 
		      // next node must be with shortest distance
		      nextVille =Tools.getTauxCO2Minimum(g);
		 
		   }
		  }
		
		
		
		
		
		/*
		 * the Dijkstra algorithm !!!  
		 * l'algorithme sert à résoudre le problème du plus court chemin. Il permet de déterminer un plus court chemin 
		 * pour se rendre d'une ville à une autre connaissant le réseau routier d'une région. Plus précisément, 
		 * il calcule des plus courts chemins à partir d'une source dans un graphe pondéré par des réels positifs. 
		 * 
		 */
		
			public static void DijKtraShortestDistances(Graphe g,Ville source,Vehicule v) {
				
				int indiceSource=Tools.getIndice(g.getVille(), source.getId()); 
				/*
				 * On récupère l'indice de la ville source dans ArrayList<Ville> du graphe (On recupère la position de la ville source dans le graphe)
				 */
			    g.getVille().get(indiceSource).setTauxEmissionCO2(0);	
			    /*
			     * On initialise le taux d'émission de CO2 à 0g dans la ville de départ
			     */
			    int nextVille = indiceSource; 
			    /*
			     * nexVille récupère l'indice de la ville courante dans l'ArrayList qui stocke l'ensemble des villes du graphe
			     */
			    int idNextVille; 
			    
			    /*
			     * récupère l'identifiant de la  ville courante 
			     */
			    
			    
			    // visit every node "ville"
			    for (int i = 0; i < g.getVille().size(); i++) {
			    	idNextVille=g.getVille().get(nextVille).getId();
			    	/*
				       *  On récupère l'identifaiant de la ville courant 
				       */
			       
			    	/* loop around the edges of current node
			    	 * on parcourt toutes les villes, et pour chaque ville on determine l'ensemble des chemins possibles
			    	 */
			      ArrayList<Chemin> currentVilleArcs = new ArrayList<Chemin> ();
			      currentVilleArcs=g.getVille().get(nextVille).getChemin(); 
			      /*
		    	   * Liste des chemins adjacents à la ville courante (NextVille) qu'on récuperera à partir du graphe 
		    	   *
			      * On parcourt la liste des arcs d'une ville 
			      */
			      for (int joinedArc = 0; joinedArc < currentVilleArcs.size(); joinedArc++) {
			    	 
			    	// Oe determine la ville voisine à nextVille
			        int IdneighbourIndex = currentVilleArcs.get(joinedArc).getNeighbourIndex(idNextVille);
			        /*
		        	 * IdneighbourIndex:stocke l'identifiant de la ville voisine
		        	 */
			        int neighbourIndex=Tools.getIndice(g.getVille(),IdneighbourIndex); //l'indice de la ville voisine
			        
			        /*
		        	 * On récupère l'indice de la ville voisine dans le graphe
		        	 */       
			        //only if not visited	
			        if (!(g.getVille().get(neighbourIndex).isVisited())) {
			        	/*		        	 
			     		 * ON calcule la distance necessaire pour  atteindre la ville voisine (neighbourIndex )
			     		 */
			        	double tentative = g.getVille().get(nextVille).getTauxEmissionCO2() + (currentVilleArcs.get(joinedArc).getDistance());
			        	
			        	/*		        	 
			     		 * ON calcule le taux d'émission du CO2 emis jusqu'à atteindre la ville neighbourIndex 
			     		 */		        	 
			        	double tentativeEmission= g.getVille().get(nextVille).getDistance() + (currentVilleArcs.get(joinedArc).getPoids()*v.calculerEmission());
			        	
			          if (tentative< ((g.getVille().get(neighbourIndex)).getTauxEmissionCO2())) {
			            (g.getVille().get(neighbourIndex)).setTauxEmissionCO2(tentative);
			            (g.getVille().get(neighbourIndex)).setDistance(tentativeEmission); //pour stocker la distance parcourue pour emettre un minimum de co2
			          }
			        }
			      }
			 
			      // all neighbours checked so node visited
			      g.getVille().get(nextVille).setVisited(true);
			 
			      // next node must be with shortest distance
			      nextVille =Tools.getTauxCO2Minimum(g);
			 
			   }
			  }
		
			
		
		  
		  
		  


}
