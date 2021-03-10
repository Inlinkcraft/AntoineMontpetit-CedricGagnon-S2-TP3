package formes;

/**
 * Enum contenant les couleurs possibles des formes
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public enum Couleur
{
	/**
	 * Couleurs possibles
	 */
	ROUGE("rouge"),VERT("vert"),BLEU("bleu"),JAUNE("jaune"),NOIR("noir"),ORANGE("orange");
	
	/**
	 * Représentation String de la couleur
	 */
	private String nom = null;
	
	/**
	 * Construit une couleur
	 * @param pNom : le nom de la couleur sour forme de String
	 */
	private Couleur(String pNom) {
		nom=pNom;
	}
	
	/**
	 * Retourne le nom de la couleur
	 * @return le nom de la couleur
	 */
	public String getNom() {
		return(nom);
	}
	
	/**
	 * Modifie le nom de la couleur
	 * @param pNom : le nouveau nom à assigner
	 */
	private void setNom(String pNom) {
		nom=pNom;
	}
	
	/**
	 * Remplace la méthode toString de la classe Object
	 * @return la représentation String de la couleur
	 */
	public String toString() {
		return(nom);
	}
	
}
