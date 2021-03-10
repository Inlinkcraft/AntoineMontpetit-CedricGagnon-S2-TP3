package formes;

import exceptions.*;

/**
 * Permet l'utilisation d'une forme Rectangle
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public class Rectangle extends Forme
{
	/**
	 * Hauteur du rectangle
	 */
	private int hauteur;
	/**
	 * Largeur du rectangle
	 */
	private int largeur;

	/**
	 * Créée un rectangle, si les paramètres sont valides
	 * @param pHauteur : Hauteur du rectangle à construire
	 * @param pLargeur : Largeur du rectangle à construire
	 * @throws FormeException : Indique la présence de paramètre(s) invalide(s)
	 */
	public Rectangle(int pHauteur, int pLargeur) throws FormeException
	{
		super("Rectangle");
		if (validerLargeur(pLargeur) && validerHauteur(pHauteur))
		{
			hauteur = pHauteur;
			largeur = pLargeur;
		}
		else
		{
			throw (new FormeException("Dimension/s de rectangle invalide/s pour construction"));
		}
	}

	/**
	 * Retourne la hauteur du rectangle
	 * @return la hauteur du rectangle
	 */
	public int getHauteur()
	{
		return (hauteur);
	}

	/**
	 * Retourne la largeur du rectangle
	 * @return la largeur du rectangle
	 */
	public int getLargeur()
	{
		return (largeur);
	}

	/**
	 * Change la hauteur du rectangle, si le paramètre est valide
	 * @param pHauteur : La hauteur à utiliser
	 */
	public void setHauteur(int pHauteur)
	{
		if (validerHauteur(pHauteur))
		{
			hauteur = pHauteur;
		}
	}

	/**
	 * Change la largeur du rectangle, si le paramètre est valide
	 * @param pLargeur : La largeur à utiliser
	 */
	public void setLargeur(int pLargeur)
	{
		if (validerLargeur(pLargeur))
		{
			largeur = pLargeur;
		}
	}

	/**
	 * Valide une valeur pour utilisation comme hauteur
	 * @param pHauteur : La valeur à valider
	 * @return vrai si la valeur est valide
	 */
	private static boolean validerHauteur(int pHauteur)
	{
		return (pHauteur >= MIN_VAL && pHauteur <= MAX_VAL);
	}

	/**
	 * Valide une valeur pour utilisation comme largeur
	 * @param pLargeur : La valeur à valider
	 * @return vrai si la valeur est valide
	 */
	private static boolean validerLargeur(int pLargeur)
	{
		return (pLargeur >= MIN_VAL && pLargeur <= MAX_VAL);
	}

	/**
	 * Calcule l'aire du rectangle
	 * @return l'aire du rectangle
	 */
	public int calculerSurface()
	{
		return (largeur * hauteur);
	}

	/**
	 * Calcule le périmètre du rectangle
	 * @return le périmètre du rectangle
	 */
	public int calculerPerimetre()
	{
		return (2 * largeur + 2 * hauteur);
	}

	/**
	 * Remplace la fonction toString de la classe Object
	 * @return la String représentant le rectangle
	 */
	public String toString()
	{
		return (super.toString() + " " + hauteur + ", " + largeur);
	}
}
