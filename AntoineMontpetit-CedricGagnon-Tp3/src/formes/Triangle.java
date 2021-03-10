package formes;

import exceptions.*;
import java.util.Arrays;

/**
 * Permet l'utilisation d'une forme Triangle
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public class Triangle extends Forme
{
	/**
	 * Côtés du triangle
	 */
	private int coteA, coteB, coteC;
	
	/**
	 * Type du triangle
	 */
	private TypeTriangle type;

	
	/**
	 * Créée un triangle, si les paramètres sont valides 
	 * @param pCoteA : Le côté A du triangle créé
	 * @param pCoteB : Le côté B du triangle créé
	 * @param pCoteC : Le côté C du triangle créé
	 * @throws FormeException : Indique qu'un des paramètres est invalide
	 */
	public Triangle(int pCoteA, int pCoteB, int pCoteC) throws FormeException
	{
		super("Triangle");
		if (validerCote(pCoteA) && validerCote(pCoteB) && validerCote(pCoteC))
		{
			if(estTriangle(pCoteA,pCoteB,pCoteC)) {
				coteA=pCoteA;
				coteB=pCoteB;
				coteC=pCoteC;
				type=getType();
			}
			else {
				throw(new FormeException("Côtés impossibles pour former un triangle"));
			}
		}
		else
		{
			throw (new FormeException("Un ou plusieurs côtés invalides pour la construction"));
		}
	}

	/**
	 * Retourne le côté A du triangle
	 * @return le côté A du triangle
	 */
	public int getCoteA()
	{
		return (coteA);
	}
	
	/**
	 * Retourne le côté B du triangle
	 * @return le côté B du triangle
	 */
	public int getCoteB()
	{
		return (coteB);
	}
	
	/**
	 * Retourne le côté C du triangle
	 * @return le côté C du triangle
	 */
	public int getCoteC()
	{
		return (coteC);
	}


	/**
	 * Valide une valeur pour utilisation comme côté du triangle
	 * @param pCote : La valeur à valider
	 * @return vrai si la valeur est valide
	 */
	private static boolean validerCote(int pCote)
	{
		return (pCote >= MIN_VAL && pCote <= MAX_VAL);
	}

	/**
	 * Calcule l'aire du triangle à l'unité près
	 * @return l'aire du triangle à l'unité près
	 */
	public int calculerSurface()
	{
		double p=((double)(coteA+coteB+coteC))/2;
		return ((int)Math.pow((p*(p-coteA)*(p-coteB)*(p-coteC)),0.5));
	}

	/**
	 * Calcule le périmètre du triangle à l'unité près
	 * @return le périmètre du triangle à l'unité près
	 */
	public int calculerPerimetre()
	{
		return (coteA+coteB+coteC);
	}

	/**
	 * Remplace la fonction toString de la classe Object
	 * @return la représentation String du triangle
	 */
	public String toString()
	{
		return (super.toString() + " " + type + " " + coteA + ", " + coteB + ", " + coteC);
	}
	
	/**
	 * Retourne le nombre de côtés égaux dans le triangle
	 * @return le nombre de côtés égaux
	 */
	private int getNbrCotesEgaux() {
		int total=1;
		if(coteA==coteB && coteB==coteC) {
			total=3;
		}
		else if(coteA==coteB || coteB==coteC || coteC==coteA) {
			total=2;
		}
		return(total);
	}
	
	/**
	 * Trie les côtés du triangle
	 * @return les côtés triés
	 */
	private int[] getCotesTries() {
		int[] cotes = {coteA,coteB,coteC};
		Arrays.sort(cotes);
		return(cotes);
	}
	
	/**
	 * Vérifie si le triangle est rectangle
	 * @return true si le triangle est rectangle
	 */
	private boolean estRectangle() {
		return(Math.pow(getCotesTries()[0],2)+Math.pow(getCotesTries()[1],2)==Math.pow(getCotesTries()[2],2));
	}
	
	/**
	 * Retourne le type du triangle entre Équilatéral, Rectangle, Isocèle et Scalène
	 * @return le type du triangle
	 */
	public TypeTriangle getType() {
		TypeTriangle out=TypeTriangle.SCALENE;
		if(getNbrCotesEgaux()==3) {
			out=TypeTriangle.EQUILATERAL;
		}
		else if(estRectangle()) {
			out=TypeTriangle.RECTANGLE;
		}
		else if(getNbrCotesEgaux()==2) {
			out=TypeTriangle.ISOCELE;
		}
		
		return(out);
	}
	
	/**
	 * Teste si il est possible de former un triangle avec les côtés suggérés
	 * @param pCoteA : Le premier côté à tester
	 * @param pCoteB : Le deuxième côté à tester
	 * @param pCoteC : Le troisième côté à tester
	 * @return true si il est possible de former un triangle avec les côtés
	 */
	private static boolean estTriangle(int pCoteA, int pCoteB, int pCoteC) {
		return(pCoteA+pCoteB>=pCoteC && pCoteA+pCoteC>=pCoteB && pCoteB+pCoteC>=pCoteA);
	}
}