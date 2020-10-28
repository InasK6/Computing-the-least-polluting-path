package graphe;
import java.util.ArrayList;
import vehicule.Vehicule;
import vehicule.VoitureEssenceLPG;
import ville.Ville;
import ville.Chemin;
import ville.Autoroute;
import ville.Montagne;
import ville.RouteNationale;
public class Test {

	public static void main(String[] args) {
		/*
		 * creation d'un vehicule
		 */
		Vehicule v=new VoitureEssenceLPG(55);
		
		
		//creation des ville
		Ville A=new Ville("A");
		Ville B=new Ville("B");
		Ville C=new Ville("C");
		Ville D=new Ville("D");
		Ville E=new Ville("E");
		Ville F=new Ville("F");
		Ville G=new Ville("G");
		Ville H=new Ville("H");
		/*
		 * crétion d'une liste de chemins
		 */
		
		Chemin[] edges = {
			      new Autoroute(A, C, 1), new Montagne(A, D, 4), new Autoroute(A, E, 2),
			      new Autoroute(A, B, 3), new RouteNationale(B, D, 2), new Montagne(B, E, 3),
			      new RouteNationale(B, F, 1), new Autoroute(C, E, 1), new Autoroute(D, F, 4),
			      new Autoroute(E, F, 2), new Autoroute(E, G, 7), new RouteNationale(E, H, 2),
			      new RouteNationale(F, G, 4), new Autoroute(G, H, 5)
			    };
			 /*
			  * Création du graphe
			  */
			/*
			 * Affichage du graphe
			 */
			    Graphe r = new Graphe(edges);
			    Tools.Graphe_affichage(r);
			    			    
			 
			    System.out.println("//////////////////////////////////////");
			    System.out.println("\n");
			   
			    System.out.println("VHEICULE UTILISE");
			    System.out.println(v.toString()+ "  Littre_consomme:"+v.getLittre_consomme()+ "littres/100km");
			    System.out.println("//////////////////////////////////////");
			    System.out.println("\n");
			    /*
			     * Afficher le plus court chemin en prenant en compte que la distance ainsi que le taux d'émission du CO2
			     */
			    Graphe R=r.copie(r);
			    Dijkstra.calculateLowerEmissionCO2(R,A,v);
			    int indice=Tools.getIndice(R.getVille(),H.getId());
				Graphe r1=r.copie(r);
				ArrayList <Ville> passage=AffichageParcourt.calculeChemin(r1,A,H,v);
				
				
				System.out.println("pour aller de  "+A.getNom()+" à  "+H.getNom()+" on vous prospose l'itinéaire suivant ");
				for(int i=passage.size()-1;i>=0;i--) {
					System.out.println(passage.get(i));
				}
				System.out.println("Distance à parcourir est:"+R.getVille().get(indice).getDistance()+"  km  "+"Taux d'émission de CO2 est de l'ordre de "+R.getVille().get(indice).getTauxEmissionCO2()+" g");
				Tools.retourParcours(r1, A,H, v);
				
				/*
				 * Comparaison des deux fonctions Dijkstra,une qui prend en compte le taux d'émission du co2 et une prend en compte que la distance parcourue
				 */
				
			    Graphe C2=r.copie(r);
			    Graphe C1=r.copie(r);
			    Dijkstra.calculateLowerEmissionCO2(C1,A,v);  //reduit le taux de co2
			    System.out.println("Resultat de la fonction Dijkstra qui prend en compte le paramètre (Taux d'Emission du CO2)\n");
			    Tools.printResultCO2(C1, A);
			    
			    Dijkstra.DijKtraShortestDistances(C2,A,v);// se base sur le plus cours chemin
			    System.out.println("Resultat de la fonction Dijkstra qui prend en compte le paramètre (Distance)\n");
			    Tools.printResultDistance(C2,A);
			    System.out.println("\n comparaison des deux fonctions Dijkstra");
			    Tools.printResult(C1,C2,A);
			    
				//tableau récapitulatif
			    Graphe gr=r.copie(r);
			    System.out.println(AffichageDijkstraTableau.calculateShortestDistancesTableau(gr,A,v));
			    System.out.println("///////////////////////\n");
			    
			   
			   

	}

	

}
