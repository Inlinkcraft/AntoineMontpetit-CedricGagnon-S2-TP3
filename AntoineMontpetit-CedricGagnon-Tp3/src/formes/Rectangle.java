package formes;

import exceptions.FormeException;

/**
 * Definition d'un rectangle
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public class Rectangle extends Forme
{

	/**
	 * La hauteur du rectangle
	 */
	private int hauteur;

	/**
	 * La largeur du rectangle
	 */
	private int largeur;

	/**
	 * Créé un rectangle d'une hauteur et largeur definie
	 * 
	 * @param pHauteur - la hauteur du rectangle
	 * @param pLargeur - la largeur du rectangle
	 * @throws FormeException - si la largeur ou hauteur n'est pas valide
	 */
	public Rectangle(int pHauteur, int pLargeur) throws FormeException
	{
		super("Rectangle");
		if (validerHauteur(pHauteur) && validerLargeur(pLargeur))
		{
			hauteur = pHauteur;
			largeur = pLargeur;
		}
		else
		{
			throw new FormeException("La hauteur ou largeur est invalide");
		}
	}

	/**
	 * Retourne la hauteur
	 * 
	 * @return - la hauteur
	 */
	public int getHauteur()
	{
		return hauteur;
	}

	/**
	 * Retourne la largeur
	 * 
	 * @return - la largeur
	 */
	public int getLargeur()
	{
		return largeur;
	}


	/**
	 * Definie une nouvelle hauteur si celle-ci est valide
	 * 
	 * @param pHauteur - la nouvelle hauteur
	 */
	public void setHauteur(int pHauteur)
	{
		if (validerHauteur(pHauteur))
		{
			hauteur = pHauteur;
		}
	}

	/**
	 * Definie une nouvelle Largeur si celle-ci est valide
	 * 
	 * @param pLargeur - la nouvelle largeur
	 */
	public void setLargeur(int pLargeur)
	{
		if (validerLargeur(pLargeur))
		{
			largeur = pLargeur;
		}
	}

	/**
	 * Valide la hauteur donner entre les deux born déféni
	 * 
	 * @param pHauteur - la hauteur
	 * @return - true si la hauteur est valide
	 */
	private boolean validerHauteur(int pHauteur)
	{
		return pHauteur >= MIN_VAL && pHauteur <= MAX_VAL;
	}

	/**
	 * valide la largeur donner entre les deux born déféni
	 * 
	 * @param pLargeur - la largeur
	 * @return - true si la largeur est valide
	 */
	private boolean validerLargeur(int pLargeur)
	{
		return pLargeur >= MIN_VAL && pLargeur <= MAX_VAL;
	}

	@Override
	public int calculerSurface()
	{
		return largeur * hauteur;
	}

	@Override
	public int calculerPerimetre()
	{
		return 2 * largeur + 2 * hauteur;
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + hauteur + " " + largeur;
	}

}
