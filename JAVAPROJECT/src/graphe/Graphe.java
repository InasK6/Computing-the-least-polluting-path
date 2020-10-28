package graphe;

import java.util.ArrayList;

import ville.Ville;
import ville.Chemin;

public class Graphe {
	/* un graphe doit contenir un ensembe de villes et de chemins
	 * 
	 */
	private  ArrayList <Ville> villes;
	/*
	 * l'ensemble des villes d'un grapge
	 */
	private int nbVilles;
	private int nbArcs; // nombre de chemins
	/*
	 * nombre de villes et chemins du graphe 
	 * On choisit de rajouter ces attributs car on considère que c'est des carctéristiques essentielles du graphe
	 * ça permet de faciliter leur récuperation
	 */
	private Chemin[] chemins;
	/*
	 * L'ensemble des chemins
	 */
	
	
	//Constructeur
	public Graphe( Chemin[] chemins){
		this.chemins=chemins;
		/*
		 * Affecte à l'attribut chemin la liste chemin
		 */
		this.nbArcs=chemins.length;
		
		this.villes=new ArrayList <Ville>();
		
		/* instancier le tableau des villes
		 */
		ArrayList <Integer> tabId=new ArrayList <Integer> (); 
		/*
		 * enregistre les identifiants des villes dans tabId
		 * Ce tableau "tabId" nous permet d'inserer que les villes qui ne sont pas encore enregistrées
		 */
		int k=0;
		boolean existfrom=true;
		boolean existto=true;
		for(Chemin a:chemins){
			existfrom=true;
			existto=true;
			for(int id:tabId){
				if((id==a.getV1().getId())){
					existfrom=false;
				}
				if((id==a.getV2().getId())){
					existto=false;
				}
			}
			
			if(existfrom){  
				/*
				 * On ajoute les villes qui n'existent pas deja dans la liste des villes du graphe
				 */
				tabId.add(a.getV1().getId());
				villes.add(a.getV1());
				k=k+1;
			}
			if(existto){
				tabId.add(a.getV2().getId());
				villes.add(a.getV2());
				/*
				 * On ajoute les villes qui n'existent pas deja dans la liste des villes du graphe
				 */

				k=k+1;
			}
		}
		for(int i=0;i<villes.size();i++){
			ArrayList <Chemin> chcopie=new ArrayList<Chemin> ();
			/*
			 * On attribut à chaque ville du graphe ses villes adjacentes
			 */
			for(Chemin a:chemins){
				if(a.villePresente(villes.get(i))){
					chcopie.add(a);
				}
			}
			villes.get(i).setChemin(chcopie);
			
		}
		this.nbVilles=villes.size();
		/*
		 * nombre de villes présentes dans le graphe
		 */
		
	}
	/*
	 * Renvoie la copie du graphe
	 */
	public Graphe copie(Graphe g){
		return new Graphe(Tools.copie(g.getChemin()));		

	}
	//Getter
	public int getNbVille(){
		return nbVilles;
	}
	public int getNbArcs(){
		return nbArcs;
	}
	public ArrayList<Ville> getVille(){
		return villes;
	}
	public Chemin[] getChemin(){
		return chemins;
	}
	//setter
	public void  setVille(ArrayList <Ville> vil){
		this.villes=vil;
	}
		
	public void setChemin(Chemin[] chemin) {
		this.chemins=chemin;
	}
	public void setnbChemin(int nbChemin) {
		this.nbArcs=nbChemin;
	}
	public void setnbVille(int nbVille) {
		this.nbVilles=nbVille;
	}

}