package graphe;

import ville.Autoroute;
import ville.Chemin;
import ville.Montagne;
import ville.RouteNationale;
import ville.Ville;

import java.util.ArrayList;
import java.util.Scanner;

import vehicule.TransportRoutierMarchandises;
import vehicule.Vehicule;
import vehicule.VoitureDiesel;
import vehicule.VoitureEssenceCNG;
import vehicule.VoitureEssenceLPG;
import vehicule.Bus;
import vehicule.Moto;


public class TestAffichage {

	/*
	 * Pour nos tests on crée un environnement de 10 villes en les définissant avec leur distances réelles
	 */
	

	
		public static void main(String[]args) {
			Vehicule v1=null;
			/*
			 * création des villes
			 */
			System.out.println("Ce programme calcule le trajet qui pour un véhicule donné emet le moins de gaz CO2 possible en partant d'une ville source vers une ville arrivée dans la base de donnée suivante:");
			Ville A=new Ville("Akbou");
			Ville B=new Ville("Bejaia");
			Ville C=new Ville("Tizi");
			Ville D=new Ville("Alger");
			Ville E=new Ville("Medea");
			Ville F=new Ville("Bouira");
			Ville G=new Ville("Jijel");
			Ville H=new Ville("Blida");
			Ville I=new Ville("Tipaza");
			Ville J=new Ville("Tenes");
			
							  
			Chemin AB=new Autoroute(A,B, 60);
			Chemin AC=new Montagne(A,C,70);
			Chemin AD=new Autoroute(A,D,120);
			Chemin BC=new RouteNationale(B,C,80);
			Chemin BD=new RouteNationale(B,D,246 );
			Chemin DC=new Montagne(D,C,106);
			Chemin AF=new Autoroute(A,F, 87);
			Chemin CF=new Autoroute(C,F,125);
			Chemin BG=new RouteNationale(B,G,89.4);
			Chemin DH=new Autoroute(D,H, 44.5);
			Chemin DI=new RouteNationale(D,I,74.1);
			Chemin HE=new RouteNationale(H,E, 33.5);
			Chemin IJ=new RouteNationale(I,J,131);
			Chemin IH=new RouteNationale(I,H,50.5);
			
			Chemin[] chemins=new Chemin[14];
			chemins[0]=AB;
			chemins[1]=AC;
			chemins[2]=BC;
			chemins[3]=AD;
			chemins[4]=BD;
			chemins[5]=DC;
			chemins[6]=AF;
			chemins[7]=CF;
			chemins[8]=BG;
			chemins[9]=DH;
			chemins[10]=DI;
			chemins[11]=HE;
			chemins[12]=IJ;
			chemins[13]=IH;
			/*
			 * création du graphe
			 */
			Graphe g = new Graphe(chemins);
			/*Graphe r=new Graphe(chemins);
			ArrayList <Ville> vil=calculeChemin(r,A,J,v);
			for(int i=vil.size()-1;i>=0;i--) {
				System.out.println(vil.get(i));
			}*/
			
			////////////////////////////////////////////////
			
			/*
			 * On crée d'abord notre véhicule
			 * Récuperation du type du véhicule
			 */
			Scanner sc=new Scanner(System.in);
			System.out.println("Veuillez saisir Le type de véhicule parmi les types suivant ( Respectez la syntaxe ): \n"
					+ "VoitureDiesel ,"+"VoitureEssenceCNG ,"+"VoitureEssenceLPG ,"+"TransportRoutierMarchandises ,"+"Bus  ,"+"Moto ");
			String str = sc.nextLine();
			
			
			/*
			 * Récupération du nombre de litre/100km du véhicule
			 */
			Scanner sc1=new Scanner(System.in);
			System.out.println("Veuillez rentrer le nombre de litre/100km consommé par votre véhicule:  vous pourrez les trouver dans les caracteristiques techniques de votre véhicule");
			String str1 = sc1.nextLine();
			
			
		
			
			if(str.equals("VoitureDiesel")){
				v1=new VoitureDiesel(Double.parseDouble(str1));
			}
			if(str.equals("VoitureEssenceCNG")) {
				v1=new VoitureEssenceCNG(Double.parseDouble(str1));
			}
			if(str.equals("VoitureEssenceLPG")) {
				v1=new VoitureEssenceLPG(Double.parseDouble(str1));
			}
			if(str.equals("TransportRoutierMarchandises")) {
				
				Scanner sc2=new Scanner(System.in);
				System.out.println("Veuillez rentrer le poids de votre marchandise");
				String str2 = sc1.nextLine();
				System.out.println("Vous avez saisi "+str2);
				v1=new TransportRoutierMarchandises(Double.parseDouble(str2),Double.parseDouble(str1));
			}
			if(str.equals("Bus")) {
				Scanner sc2=new Scanner(System.in);
				System.out.println("Veuillez rentrer le nombre de places occupées");
				String str2 = sc1.nextLine();
				System.out.println("Vous avez saisi "+str2 +" places");
				v1= new Bus(Double.parseDouble(str1),Integer.parseInt(str2));
			}
			if(str.equals("Moto")) {
				v1=new Moto(Double.parseDouble(str1));
			}
			
			
			/*
			 * On demande la source et la destination pour pouvoir appeler Dijikstra avec
			 */
			String s="";
			for (Ville a: g.getVille()) {
				s+=a.getNom();
				s+=" ,";
			}
			System.out.println(s);
			
			Scanner sc3=new Scanner(System.in);
			System.out.println("Veuillez rentrer votre ville source (La première lettre doit être en majuscule, le reste en minuscule)");
			String str3 = sc3.nextLine();
			
			/*
			 * Récuperation de l'Id de la ville source
			 */
			Ville Source=Tools.getVille(str3, g.getVille());
			
			
			Scanner sc4=new Scanner(System.in);
			System.out.println("Veuillez rentrer votre ville destination (La première lettre doit être en majuscule, le reste en minuscule)");
			String str4 = sc4.nextLine();
			
			/*
			 * Récuperation de l'Id de la ville destination
			 */
			Ville Destination=Tools.getVille(str4, g.getVille());
			
			
			/*
			 * Récapitulatif
			 */
			System.out.println(v1);
			System.out.println("Calcul de Parcours de "+str3+" vers "+str4);
			
			Graphe r=new Graphe(chemins);
			ArrayList <Ville> vil=AffichageParcourt.calculeChemin(r,Source,Destination,v1);
			for(int i=vil.size()-1;i>=0;i--) {
				System.out.println(vil.get(i));
			}
			Tools.retourParcours(r, Source,Destination, v1);
		}
		
}