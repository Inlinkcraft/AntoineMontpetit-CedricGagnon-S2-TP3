package formes;

import exceptions.*;

/**
 * Permet l'utilisation d'une forme Cercle
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public class Cercle extends Forme
{
	/**
	 * Rayon du cercle
	 */
	private int rayon;

	/**
	 * Créée un cercle, si le paramètre est valide 
	 * @param pRayon : Le rayon du cercle créé
	 * @throws FormeException : Indique que le paramètre est invalide
	 */
	public Cercle(int pRayon) throws FormeException
	{
		super("Cercle");
		if (validerRayon(pRayon))
		{
			rayon = pRayon;
		}
		else
		{
			throw (new FormeException("Rayon invalide pour construction"));
		}
	}

	/**
	 * Retourne le rayon du cercle
	 * @return le rayon du cercle
	 */
	public int getRayon()
	{
		return (rayon);
	}

	/**
	 * Change le rayon du Cercle, si le paramètre est valide
	 * @param pRayon : Le rayon à utiliser
	 */
	public void setRayon(int pRayon)
	{
		if (validerRayon(pRayon))
		{
			rayon = pRayon;
		}
	}

	/**
	 * Valide une valeur pour utilisation comme rayon
	 * @param pRayon : La valeur à valider
	 * @return vrai si la valeur est valide
	 */
	private static boolean validerRayon(int pRayon)
	{
		return (pRayon >= MIN_VAL && pRayon <= MAX_VAL);
	}

	/**
	 * Calcule l'aire du cercle à l'unité près
	 * @return l'aire du cercle à l'unité près
	 */
	public int calculerSurface()
	{
		return ((int) (Math.PI * Math.pow(rayon, 2)));
	}

	/**
	 * Calcule la circonférence du cercle à l'unité près
	 * @return la circonférence du cercle à l'unité près
	 */
	public int calculerPerimetre()
	{
		return ((int) (Math.PI * 2 * rayon));
	}

	/**
	 * Remplace la fonction toString de la classe Object
	 * @return la string représentant le cercle
	 */
	public String toString()
	{
		return (super.toString() + " " + rayon);
	}
}