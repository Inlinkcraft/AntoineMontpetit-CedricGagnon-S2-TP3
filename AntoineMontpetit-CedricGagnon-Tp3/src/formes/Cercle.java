package formes;

import exceptions.FormeException;

/**
 * 
 * Defenition d'un cercle
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public class Cercle extends Forme
{

	/**
	 * Le rayon du cercle
	 */
	private int rayon;

	/**
	 * Construit un cercle avec un rayon dénie
	 * 
	 * @param pRayon - grandeur du rayon
	 * @throws FormeException - FormeException si le cercle a un rayon invalide
	 * 
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
			throw new FormeException();
		}
	}

	/**
	 * Retourne le rayon
	 * 
	 * @return - le rayon
	 */
	public int getRayon()
	{
		return rayon;
	}

	/**
	 * Définit un nouveau rayon si celui-ci est valide
	 * 
	 * @param pRayon - nouveau rayon
	 */
	public void setRayon(int pRayon)
	{
		if (validerRayon(pRayon))
		{
			rayon = pRayon;
		}
	}

	/**
	 * Valide si un rayon est entre les borne défénie
	 * 
	 * @param pRayon - le rayon a valider
	 * @return - true si le rayon est valide
	 */
	private boolean validerRayon(int pRayon)
	{
		return pRayon >= MIN_VAL && pRayon <= MAX_VAL;
	}

	@Override
	public int calculerSurface()
	{
		return (int) (Math.PI * Math.pow(rayon, 2));
	}

	@Override
	public int calculerPerimetre()
	{
		return (int) (rayon * 2 * Math.PI);
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + rayon;
	}

}
