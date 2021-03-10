package formes;

/**
 * Definition d'une forme
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public abstract class Forme implements Comparable<Forme>
{
	/**
	 * La grandeur miniumum d'une forme
	 */
	public static final int MIN_VAL = 1;

	/**
	 * La grandeur maximum d'une forme
	 */
	public static final int MAX_VAL = 30;

	/**
	 * La couleur par default d'une forme
	 */
	public static final Couleur COULEUR_DEFAULT = Couleur.ROUGE;

	/**
	 * Le nom de la forme
	 */
	private String nom;

	/**
	 * La couleur de la forme
	 */
	private Couleur couleur;

	/**
	 * Créé une forme avec un nom
	 * 
	 * @param pNom - le nom de la forme
	 */
	public Forme(String pNom)
	{
		if (pNom != null)
		{
			nom = pNom;
			couleur = COULEUR_DEFAULT;
		}
	}

	/**
	 * Get le nom de la forme
	 * 
	 * @return - le nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Get la couleur de la forme
	 * 
	 * @return - la couleur
	 */
	public Couleur getCouleur()
	{
		return couleur;
	}

	/**
	 * Set une nouvelle couleur à la forme
	 * 
	 * @param pCouleur - la nouvelle couleur
	 */
	public void setCouleur(Couleur pCouleur)
	{
		if (pCouleur != null)
		{
			couleur = pCouleur;
		}
	}

	/**
	 * Calucle la surface
	 * 
	 * @return - la surface de la forme
	 */
	public abstract int calculerSurface();

	/**
	 * Calcule le perimetre de la forme
	 * 
	 * @return - le perimetre de la forme
	 */
	public abstract int calculerPerimetre();

	@Override
	public String toString()
	{
		return nom + " " + couleur.toString();
	}

	public String toStringCourt()
	{
		return nom + " " + couleur.toString();
	}

	@Override
	public int compareTo(Forme pForme)
	{
		return (this.getNom() + this.couleur)
				.compareTo(pForme.getNom() + pForme.couleur);
	}

	@Override
	public boolean equals(Object pObj)
	{
		boolean egale = false;
		Forme pForme = (Forme) pObj;

		if (pForme instanceof Forme)
		{
			egale = this.getNom().equals(pForme.getNom())
					&& this.getCouleur().equals(pForme.getCouleur())
					&& this.calculerSurface() == pForme.calculerSurface();
		}

		return egale;
	}
}
