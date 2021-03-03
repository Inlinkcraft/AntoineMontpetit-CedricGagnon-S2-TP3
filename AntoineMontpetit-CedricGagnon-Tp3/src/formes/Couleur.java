package formes;

/**
 * Defenition des couleur
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public enum Couleur
{
	/**
	 * Les Couleur
	 */
	ROUGE("rouge"), VERT("vert"), BLEU("bleu"), JAUNE("jaune"), NOIR(
			"noir"), ORANGE("orange");

	/**
	 * Nom de la couleur
	 */
	private String nom;

	/**
	 * Construit une couleur
	 * 
	 * @param pNom - Le nom de la couleur
	 */
	Couleur(String pNom)
	{
		setNom(pNom);
	}

	/**
	 * Retourne le nom de la couleur
	 * 
	 * @return - nom de la couleur
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Set un nouveau nom a la couleur
	 * 
	 * @param pNom - le nom de la couleur
	 */
	private void setNom(String pNom)
	{
		nom = pNom;
	}

	@Override
	public String toString()
	{
		return nom;
	}
}
