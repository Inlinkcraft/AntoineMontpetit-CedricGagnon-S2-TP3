package formes;

import exceptions.*;

/**
 * Base pour les classes Rectangle, Cercle et Triangle
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public abstract class Forme implements Comparable<Forme>
{
	/**
	 * Valeur minimale des longueurs des formes
	 */
	public static final int MIN_VAL = 1;
	/**
	 * Valeur maximale des longueurs des formes
	 */
	public static final int MAX_VAL = 30;
	/**
	 * Couleurs assignables aux formes
	 */
	public static final Couleur[] LES_COULEURS = {Couleur.ROUGE,Couleur.VERT,Couleur.BLEU,Couleur.JAUNE,Couleur.NOIR,Couleur.ORANGE};
	/**
	 * Type de forme sous forme de String
	 */
	private String nom = null;
	/**
	 * Couleur de la forme
	 */
	private Couleur couleur;
	
	
	/**
	 * Assigne le nom et la couleur à la forme
	 * @param pNom : le nom à assigner
	 * @throws FormeException : relancée si levée par constructeur appelant
	 */
	public Forme(String pNom) throws FormeException {
		couleur=Couleur.ROUGE;
		nom=pNom;
	}
	
	/**
	 * Retourne le nom de la forme
	 * @return le nom de la forme
	 */
	public String getNom()
	{
		return (nom);
	}
	
	/**
	 * Retourne la couleur de la forme
	 * @return la couleur de la forme
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	
	public void setCouleur(Couleur pCouleur) {
		if(validerCouleur(pCouleur)) {
			couleur=pCouleur;
		}
	}
	
	/**
	 * Calcule le périmètre de la forme 
	 * @return le périmètre de la forme
	 */
	public abstract int calculerPerimetre();
	
	/**
	 * Calcule l'aire de la forme
	 * @return l'aire de la forme
	 */
	public abstract int calculerSurface();
	
	/**
	 * Valide une couleur pour l'assignation à la forme
	 * @param pCouleur : La couleur à valider
	 * @return true si la couleur est valide
	 */
	private static boolean validerCouleur(Couleur pCouleur)
	{
		boolean valide = false;
		if(pCouleur!=null) {
			for (int i = 0; i < LES_COULEURS.length && !valide; i++)
			{
				if (pCouleur.equals(LES_COULEURS[i]))
				{
					valide = true;
				}
			}
		}
		return (valide);
	}
	
	/**
	 * Remplace la méthode toString de la classe Object
	 * @return la string qui représente la forme
	 */
	@Override
	public String toString() {
		return(nom + " " +couleur);
	}
	
	/**
	 * Version courte de toString
	 * @return la string courte qui représente la forme
	 */
	public String toStringCourt() {
		return(nom + " " +couleur);
	}
	
	/**
	 * Remplace la méthode equals de la classe Object
	 * @return true si la forme et l'objet sont égaux
	 */
	public boolean equals(Object param){
		return(param!=null && param instanceof Forme && nom.equals(((Forme)param).nom) && couleur.equals(((Forme)param).couleur) && calculerSurface()==((Forme)param).calculerSurface());
	}
	
	/**
	 * Permet de comparer deux formes
	 * @return la différence entre les formes, 0 s'ils sont égaux*   *(n'applique pas les mêmes conditions que .equals())
	 */
	public int compareTo(Forme pObj) throws NullPointerException {
		if(pObj==null) {
			throw new NullPointerException();
		}
		
		return((nom+couleur).compareTo(pObj.nom+pObj.couleur));
	}
	
	public static void main(String[] args) throws FormeException
	{
		Forme test = new Cercle(5);
		Forme test2= new Rectangle(3,4);
		Forme test3= new Triangle(5,7,10);
		
		test.setCouleur(Couleur.BLEU);
		test2.setCouleur(Couleur.ROUGE);
		test3.setCouleur(Couleur.JAUNE);
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test3);
	}
}
