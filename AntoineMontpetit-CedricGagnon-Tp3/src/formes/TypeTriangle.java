package formes;

/**
 * Defenition d'un cercle
 * 
 * @author Antoine Montpetit
 * @version 0.0.1 (hiver 2021)
 *
 */
public enum TypeTriangle
{

	/**
	 * Les type de triangle
	 */
	ISOCELE("isocele"), EQUILATERAL("equilateral"), RECTANGLE(
			"rectangle"), SCALENE("scalene");

	/**
	 * Le type de triangle
	 */
	private String type;

	/**
	 * Créé un Type de triangle
	 * 
	 * @param pType - Le type de triangle
	 */
	private TypeTriangle(String pType)
	{
		setType(pType);
	}

	/**
	 * Retourne le type de triangle
	 * 
	 * @return - le type de triangle
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Set un nouveau type de triangle
	 * 
	 * @param pType - nouveau type
	 */
	private void setType(String pType)
	{
		type = pType;
	}

	@Override
	public String toString()
	{
		return type;
	}

}
