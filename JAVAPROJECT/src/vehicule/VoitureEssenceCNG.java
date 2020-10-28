package vehicule;

/*
 * Le CNG ou gaz naturel pour véhicule est un carburant composé à 90% de méthane. Il est généralement stocké sous pression dans des réservoirs spécifiques à l'intérieur du véhicule.
 */
public class VoitureEssenceCNG extends VoitureEssence{
	protected String type_cng;
	public VoitureEssenceCNG(double littre_consomme) {
		super(littre_consomme);
		type_cng="CNG";
	}
	public String toString() {
		return super.toString()+" CNG";
	}
	public double calculerEmission(){ // la distance doit etre en Km
		double emission_par_km;
			/*
			 * est la masse du dioxyde de carbone émise par un véhicule à essence en parcourant 1km
			 */
			emission_par_km=(1819*this.getLittre_consomme())/100; 
			return emission_par_km;
		
	}
	/* Justification de la valeur 1819
	 * Le CNG est un carburant à l'état gazeux (gaz naturel) qui est stocké sous haute pression. La consommation s'exprime donc en m3/100km. Nm3 correspond à un mètre cubique en condition normale (1 atm et 0°C).
		1 Nm3 de CNG pèse 717 grammes. Le CNG est composé à 69.2% de carbone (C), ce qui correspond à 496 g de C par Nm3 de CNG. Pour brûler ce C en CO2, 1323 g d'oxygène sont nécessaires. La somme nous donne donc 496 + 1323 = 1819 g de CO2 par Nm3 de CNG.

	 */

}
