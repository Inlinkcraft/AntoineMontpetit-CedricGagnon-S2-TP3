package formes;

import java.util.Arrays;

import exceptions.FormeException;

/**
 * Definition d'un rectangle
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public class Triangle extends Forme
{

	/**
	 * Longeur du côter A
	 */
	private int coteA;

	/**
	 * Longeur du côter B
	 */
	private int coteB;

	/**
	 * Longeur du côter C
	 */
	private int coteC;

	/**
	 * Créé un triangle selon trois longeur
	 * 
	 * @param pCoteA - longueur du premier coter
	 * @param pCoteB - longueur du deuxieme coter
	 * @param pCoteC - longueur du troisieme coter
	 * @throws FormeException - lancer si le triangle est invalide
	 */
	public Triangle(int pCoteA, int pCoteB, int pCoteC) throws FormeException
	{
		super("Triangle");
		if (validerCote(pCoteA) && validerCote(pCoteB) && validerCote(pCoteC))
		{
			if (estTriangle(pCoteA, pCoteB, pCoteC))
			{
				coteA = pCoteA;
				coteB = pCoteB;
				coteC = pCoteC;
			}
			else
			{
				throw new FormeException("Ce n'ai pas un triangle");
			}

		}
		else
		{
			throw new FormeException("La hauteur ou largeur est invalide");
		}
	}

	/**
	 * Get la longueur du coter a
	 * 
	 * @return - le cote a
	 */
	public int getCoteA()
	{
		return coteA;
	}

	/**
	 * Get la longueur du coter b
	 * 
	 * @return - le cote b
	 */
	public int getCoteB()
	{
		return coteB;
	}

	/**
	 * Get la longueur du coter c
	 * 
	 * @return - le cote c
	 */
	public int getCoteC()
	{
		return coteC;
	}

	/**
	 * Valide le coter donner entre les deux born déféni
	 * 
	 * @param pCote - le coter
	 * @return - true si le coter est valide
	 */
	private boolean validerCote(int pCote)
	{
		return pCote >= MIN_VAL && pCote <= MAX_VAL;
	}

	@Override
	public int calculerSurface()
	{
		double s = calculerPerimetre() / 2.0;
		return (int) (Math.sqrt(s * (s - coteA) * (s - coteB) * (s - coteC)));
	}

	@Override
	public int calculerPerimetre()
	{
		return coteA + coteB + coteC;
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + getType() + " " + coteA + " " + coteB + " " + coteC;
	}

	/**
	 * Get tous les coter eguaux
	 * 
	 * @return - le nombre de coter éguaux
	 */
	private int getNbrCoteEgaux()
	{
		int coteEgaux = 0;
		
		if (coteA == coteB) 
		{
			coteEgaux++;
		}

		if (coteA == coteC) 
		{
			coteEgaux++;
		}
			
		if (coteC == coteB) 
		{
			coteEgaux++;
		}
		
		return coteEgaux;
	}

	/**
	 * Trie les coter du plus petit au plus grand
	 * 
	 * @return - les coter trier
	 */
	private int[] getCotesTries()
	{
		int[] cotes = new int[]
		{ coteA, coteB, coteC };
		Arrays.sort(cotes);
		return cotes;
	}

	/**
	 * Determine si le triangle est rectangle
	 * 
	 * @return - true si le triangle est rectangle
	 */
	private boolean estRectangle()
	{
		int[] cotesTri = getCotesTries();
		return Math.pow(cotesTri[2], 2) == Math.pow(cotesTri[1], 2)
				+ Math.pow(cotesTri[0], 2);
	}

	/**
	 * Get le type de triangle
	 * 
	 * @return - le type de triangle
	 */
	public TypeTriangle getType()
	{

		TypeTriangle typeTriangle = null;

		if (getNbrCoteEgaux() == 3)
		{
			typeTriangle = TypeTriangle.EQUILATERAL;
		}
		else if (getNbrCoteEgaux() == 1)
		{
			typeTriangle = TypeTriangle.ISOCELE;
		}
		else if (estRectangle())
		{
			typeTriangle = TypeTriangle.RECTANGLE;
		}
		else
		{
			typeTriangle = TypeTriangle.SCALENE;
		}

		return typeTriangle;
	}

	/**
	 * Valide si le triangle est rectangle
	 * 
	 * @param pCoteA - longueur du premier coter
	 * @param pCoteB - longueur du deuxieme coter
	 * @param pCoteC - longueur du troisieme coter
	 * @return - true si le triangle est rectangle
	 */
	private static boolean estTriangle(int pCoteA, int pCoteB, int pCoteC)
	{
		boolean estTriangleValide = true;

		if (pCoteA + pCoteB < pCoteC)
			estTriangleValide = false;

		if (pCoteB + pCoteC < pCoteA)
			estTriangleValide = false;

		if (pCoteC + pCoteA < pCoteB)
			estTriangleValide = false;

		return estTriangleValide;
	}

}
