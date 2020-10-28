package graphe;
import java.util.ArrayList;
import vehicule.Vehicule;
import ville.Ville;
import ville.Chemin;

public class AffichageDijkstraTableau {
	/* Classe d'Affichage 
	 * 
	 * affichage de dijkstra sous forme d'un tableau
	 * 
	 * 1/  La méthode calculateShortestDistancesTableau retourne les résultats intermédiares de Dijkstra(méthode dijkstra prenant que le paramètre distance en compte) sous forme d'un tableau
	 * 
	 * 2/ La methode calculateLowerEmissionCO2Tableau renvoie  les résultats intermédiares de Dijkstra(méthode dijkstra prenant  le paramètre taux d'émission de co2 en compte) sous forme d'un tableau
	 */
	public static String calculateShortestDistancesTableau(Graphe g,Ville source,Vehicule v) {
		String s="          ";
		for(int i=0;i<g.getNbVille();i++){
			s+=g.getVille().get(i).getNom()+"       ";
		}
		s+="\n";
		Ville scop=source.copie(source);
		int indiceSource=Tools.getIndice(g.getVille(), scop.getId());
	    g.getVille().get(indiceSource).setTauxEmissionCO2(0);			    
	    int nextVille = indiceSource; 
	    int idNextVille=scop.getId(); 	    			    
	    ArrayList <Ville> tab=new ArrayList<Ville> ();			    
	    for (int i = 0; i < g.getVille().size(); i++) {
	    	tab=Tools.copie(g.getVille());
	    	s+= g.getVille().get(nextVille).getNom()+"("+String.format("%.1f",+g.getVille().get(nextVille).getTauxEmissionCO2() )+")    ";
	    	idNextVille=g.getVille().get(nextVille).getId();
	      ArrayList<Chemin> currentVilleArcs = new ArrayList<Chemin> ();
	      currentVilleArcs=g.getVille().get(nextVille).getChemin(); 
	      for (int joinedArc = 0; joinedArc < currentVilleArcs.size(); joinedArc++) {
	    	 
	   
	        int IdneighbourIndex = currentVilleArcs.get(joinedArc).getNeighbourIndex(idNextVille);
	        int neighbourIndex=Tools.getIndice(g.getVille(),IdneighbourIndex); 
	        
	        if (!(g.getVille().get(neighbourIndex).isVisited())) {
	        	double tentative = g.getVille().get(nextVille).getTauxEmissionCO2() + (currentVilleArcs.get(joinedArc).getDistance());
	        	(tab.get(neighbourIndex)).setTauxEmissionCO2(tentative);
	          if (tentative< ((g.getVille().get(neighbourIndex)).getTauxEmissionCO2())) {
	            (g.getVille().get(neighbourIndex)).setTauxEmissionCO2(tentative);
	            
	          }
	        }
	      }
	    //afficher les ville
	      for(int k=0;k<g.getNbVille();k++){
	    	  	if(tab.get(k).getTauxEmissionCO2()!=Integer.MAX_VALUE){
	    	  		s+=String.format("%.1f",tab.get(k).getTauxEmissionCO2())+"     ";
	    	  	}
	    	  	else{
	    	  		
	    	  		s+="inf     ";
	    	  	}
	    	 
	      }
	      s+="\n";
	      
	      g.getVille().get(nextVille).setVisited(true);
	      nextVille =Tools.getTauxCO2Minimum(g);
	 
	   }
	    
	    return s;
	  }		
	
	
	
	/*
	La methode calculateLowerEmissionCO2Tableau renvoie  les résultats intermédiares de Dijkstra(méthode dijkstra prenant  le paramètre taux d'émission de co2 en compte) sous forme d'un tableau

	 */  		 
	public static String calculateLowerEmissionCO2Tableau(Graphe g,Ville source,Vehicule v) {
					String s="            ";
					for(int i=0;i<g.getNbVille();i++){
						s+=g.getVille().get(i).getNom()+"            ";
					}
					s+="\n";
					Ville scop=source.copie(source);
					int indiceSource=Tools.getIndice(g.getVille(), scop.getId()); 
				    
				    g.getVille().get(indiceSource).setTauxEmissionCO2(0);
				    int nextVille = indiceSource; 
				    int idNextVille=scop.getId();		    
				    
				    ArrayList <Ville> tab=new ArrayList<Ville> ();
				    for (int i = 0; i < g.getVille().size(); i++) {
				    	tab=Tools.copie(g.getVille());
				    	/*
				    	 * je rajoute la ville courante au string s
				    	 */
				    	s+= g.getVille().get(nextVille).getNom()+"("+String.format("%.1f",+g.getVille().get(nextVille).getTauxEmissionCO2() )+")   ";
				    	idNextVille=g.getVille().get(nextVille).getId();
				      
				      ArrayList<Chemin> currentVilleArcs = new ArrayList<Chemin> ();
				      currentVilleArcs=g.getVille().get(nextVille).getChemin();
				      for (int joinedArc = 0; joinedArc < currentVilleArcs.size(); joinedArc++) {
				    
				        int IdneighbourIndex = currentVilleArcs.get(joinedArc).getNeighbourIndex(idNextVille);
				        int neighbourIndex=Tools.getIndice(g.getVille(),IdneighbourIndex); 
				        
				        if (!(g.getVille().get(neighbourIndex).isVisited())) {
				        	double tentative = g.getVille().get(nextVille).getTauxEmissionCO2() + (currentVilleArcs.get(joinedArc).getPoids()*v.calculerEmission());
				        	(tab.get(neighbourIndex)).setTauxEmissionCO2(tentative);
				          if (tentative < ((g.getVille().get(neighbourIndex)).getTauxEmissionCO2())) {
				            (g.getVille().get(neighbourIndex)).setTauxEmissionCO2(tentative);
				            
				          }
				        }
				        /*
				         * je rajoute les villes au tableau stocké dans s
				         */
					    
					      
				        
					   
				 
				      }
				      for(int k=0;k<tab.size();k++){
				    	  	if(tab.get(k).getTauxEmissionCO2()!=Integer.MAX_VALUE){
				    	  		s+=String.format("%.1f",tab.get(k).getTauxEmissionCO2())+"          ";
				    	  	}
				    	  	else{
				    	  		
				    	  		s+="inf           ";
				    	  	}
				    	 
				      }
				      
					  s+="\n";
				      g.getVille().get(nextVille).setVisited(true);
				      nextVille =Tools.getTauxCO2Minimum(g);
				 
				    
				   
				  }
				    return s;
				}

}
